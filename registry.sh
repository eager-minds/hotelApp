#!/bin/bash

TOOLS="tools"
SCHEMA_REGISTRY_HOST="http://localhost:8081"
AVRO_TOOL_JAR="avro-tools.jar"
AVRO_TOOL_URL=https://repo1.maven.org/maven2/org/apache/avro/avro-tools/1.11.1/avro-tools-1.11.1.jar
CONTENT_TYPE_SCHEMA_REGISTRY_JSON="Content-Type: application/vnd.schemaregistry.v1+json"
COMPATIBILITY='{"compatibility": "FULL_TRANSITIVE"}'
CONTRACTS_IDL_PATH="contracts/idl"
CONTRACTS_AVRO_PATH="contracts/avro"

if [ ! -d ${TOOLS} ] || [ ! -f ${TOOLS}/${AVRO_TOOL_JAR} ]; then
  mkdir -p "${TOOLS}"
  curl -L -o ${TOOLS}/${AVRO_TOOL_JAR} ${AVRO_TOOL_URL}
fi
TOPICS=(
  hotel_availability_searches
)

echo
echo "Setting up SCHEMA-REGISTRY..."
sleep 1.5

for topic in "${TOPICS[@]}"; do
  echo
  echo "#############################################"
  echo "    ${topic}" | tr '[:lower:]' '[:upper:]'
  echo "#############################################"
  echo
  echo "- Setting up topic compatibility."
  echo "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^"
  printf "Setting compatibility to topic %s:" "$topic-key"
  curl -X PUT -H "${CONTENT_TYPE_SCHEMA_REGISTRY_JSON}" \
    --data "${COMPATIBILITY}" \
    "${SCHEMA_REGISTRY_HOST}/config/${topic}-key"
  echo
  printf "Setting compatibility to topic %s:" "$topic-value"
  curl -X PUT -H "${CONTENT_TYPE_SCHEMA_REGISTRY_JSON}" \
    --data "${COMPATIBILITY}" \
    "${SCHEMA_REGISTRY_HOST}/config/${topic}-value"
  echo

  echo
  echo "- Generating avros under ./${CONTRACTS_AVRO_PATH}/${topic}"
  echo "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^"
  mkdir -p "${CONTRACTS_AVRO_PATH}/${topic}"
  java -jar ${TOOLS}/${AVRO_TOOL_JAR} idl2schemata \
    "${CONTRACTS_IDL_PATH}/${topic}.avdl" \
    "${CONTRACTS_AVRO_PATH}/${topic}"
  printf "Generated avros under %s:" "$topic"
  echo
  ls "${CONTRACTS_AVRO_PATH}/${topic}"
  keyTopicFile=$(find "contracts/avro/${topic}" -name "*Key.avsc" -exec basename {} \;)
  valueTopicFile=$(find "contracts/avro/${topic}" -name "*Value.avsc" -exec basename {} \;)
  payloadKey=$(jq tostring "${CONTRACTS_AVRO_PATH}/${topic}/${keyTopicFile}")
  payloadValue=$(jq tostring "${CONTRACTS_AVRO_PATH}/${topic}/${valueTopicFile}")

  echo
  echo "- Registering topics to schema-registry:"
  echo "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^"
  printf "%s-key: " "${topic}"
  curl -X POST -H "${CONTENT_TYPE_SCHEMA_REGISTRY_JSON}" -d"{\"schema\":${payloadKey}}" \
    http://localhost:8081/subjects/"${topic}"-key/versions
  echo
  printf "%s-value: " "${topic}"
  curl -X POST -H "${CONTENT_TYPE_SCHEMA_REGISTRY_JSON}" -d"{\"schema\":${payloadValue}}" \
    http://localhost:8081/subjects/"${topic}"-value/versions
  echo
done