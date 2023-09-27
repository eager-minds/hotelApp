#!/bin/bash

PS3='Please select a typology:'
options=("kafka-source-api" "kafka-sink-persist" "mongodb-api" "Quit")
select opt in "${options[@]}"
do
    case $opt in
        "kafka-source-api")
            typology="kafka-source-api"
            echo "typology=kafka-source-api"
            break
            ;;
        "kafka-sink-persist")
            typology="kafka-sink-persist"
            echo "typology=kafka-sink-persist"
            break
            ;;
        "mongodb-api")
            typology="mongodb-api"
            echo "typology=mongodb-api"
            break
            ;;
        "Quit")
            exit 0
            ;;
        *) echo "invalid option $REPLY";;
    esac
done

domainArtifactId="${1:-eagerminds-showcase}"

domainGroupId="${2:-showcase}"
version="1.0.0-SNAPSHOT"
topicName="${3:-eagerminds-showcase}"
topicEntityName="${4:-EagerMindsShowcase}"

# ./mvnArchetypeGenerate.sh hotel-availability-search hotel.availability.search hotel_availability_searches AvailabilitySearch
#domainArtifactId="${1:-hotel-availability-search}"
#domainGroupId="hotel.availability.search"
#artifactId="${domainArtifactId}-${typology}"
#topicName="hotel_availability_searches"
#topicEntityName="AvailabilitySearch"
#schemaRegistryTopicsPattern="^${topicName}-(key|value)$"
artifactId="${domainArtifactId}"-"${typology}"

eagermindsCoreVersion="1.0.0-SNAPSHOT"
eagermindsCoreArtifact="eagerminds-core-${typology}-archetype"

mvn archetype:generate -DarchetypeGroupId="tech.eagerminds.core" \
                       -DarchetypeArtifactId="${eagermindsCoreArtifact}" \
                       -DarchetypeVersion="${eagermindsCoreVersion}" \
                       -DeagermindsCoreVersion="${version}" \
                       -DgroupId="tech.eagerminds.${domainGroupId}" \
                       -DartifactId="${artifactId}" \
                       -Dtypology="${typology}" \
                       -DtopicName="${topicName}" \
                       -DtopicEntityName="${topicEntityName}" \
                       -DentityName="${topicEntityName}" \
                       -DartifactIdCamelCase="${artifactIdCamelCase}" \
                       -DschemaRegistryTopicsPattern="${schemaRegistryTopicsPattern}"
