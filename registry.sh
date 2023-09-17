#!/bin/bash

TOOLS="tools"
SCHEMA_REGISTRY_HOST="http://localhost:8081"
AVRO_TOOL_JAR="avro-tools.jar"
AVRO_TOOL_URL=https://repo1.maven.org/maven2/org/apache/avro/avro-tools/1.9.2/avro-tools-1.9.2.jar
CONTENT_TYPE_SCHEMA_REGISTRY_JSON="Content-Type: application/vnd.schemaregistry.v1+json"
COMPATIBILITY='{"compatibility": "FULL_TRANSITIVE"}'
CONTRACTS_IDL_PATH="contracts/idl"
CONTRACTS_AVRO_PATH="contracts/avro"

if [ ! -d ${TOOLS} ] || [ ! -f ${TOOLS}/${AVRO_TOOL_JAR} ]; then
  mkdir -p "${TOOLS}"
  curl -L -o ${TOOLS}/${AVRO_TOOL_JAR} ${AVRO_TOOL_URL}
fi
TOPICS=(
  hotel_availability_searches-key
  hotel_availability_searches-value
)

echo
echo "Setting up SCHEMA-REGISTRY..."
sleep 1.5

echo
echo "#############################################"
echo "Generated avros at ./${CONTRACTS_AVRO_PATH}"
echo "#############################################"
for topic in "${TOPICS[@]}"; do
  printf "Setting compatibility to topic %s:" "$topic"
  curl -X PUT -H "${CONTENT_TYPE_SCHEMA_REGISTRY_JSON}" \
    --data "${COMPATIBILITY}" \
    "${SCHEMA_REGISTRY_HOST}/config/${topic}"
  echo
done

echo
echo "#############################################"
echo "Generated avros at ./${CONTRACTS_AVRO_PATH}"
echo "#############################################"
java -jar ${TOOLS}/${AVRO_TOOL_JAR} idl2schemata \
  ${CONTRACTS_IDL_PATH}/hotel_availability_searches.avdl \
  ${CONTRACTS_AVRO_PATH}
ls ${CONTRACTS_AVRO_PATH}

payloadKey=$(jq tostring ${CONTRACTS_AVRO_PATH}/AvailabilitySearchKey.avsc)
payloadValue=$(jq tostring ${CONTRACTS_AVRO_PATH}/AvailabilitySearchValue.avsc)

echo
echo "#############################################"
echo "Register topics to schema-registry:"
echo "#############################################"
printf "hotel_availability_searches-key: "
curl -X POST -H "${CONTENT_TYPE_SCHEMA_REGISTRY_JSON}" -d"{\"schema\":${payloadKey}}" \
  http://localhost:8081/subjects/hotel_availability_searches-key/versions
echo
printf "hotel_availability_searches-value: "
curl -X POST -H "${CONTENT_TYPE_SCHEMA_REGISTRY_JSON}" -d"{\"schema\":${payloadValue}}" \
  http://localhost:8081/subjects/hotel_availability_searches-value/versions
echo
