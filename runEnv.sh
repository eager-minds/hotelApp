#!/bin/bash

docker network create eagerminds_hotel
docker-compose -f ./composes/docker-compose-kafka.yml -p kafka-stack up -d
docker-compose -f ./composes/docker-compose-mongodb.yml -p mongodb-stack up -d

defaultRetries=10
retries=$defaultRetries
cont=0
while [ $cont -le $retries ]; do
  if [ $cont -gt 0 ]; then
    echo "Waiting for schema-registry... retry: $cont/$retries"
  fi
  schemaRegistryStatus=$(curl --write-out '%{http_code}' --silent --output /dev/null localhost:8081)
  if [[ "$schemaRegistryStatus" -eq 200 ]]; then
    echo
    echo "#schema-registry is running!"
    ./registry.sh
    break
  fi
  sleep 1.5
  ((cont++))

  if [ "$cont" -gt $retries ]; then
    PS3='Schema-registry is not running, try Again?'
    options=("Yes" "No")
    select opt in "${options[@]}"; do
      case $opt in
      "Yes")
        retries=$((retries + defaultRetries))
        break
        ;;
      "No")
        break
        ;;
      *) echo "invalid option $REPLY" ;;
      esac
    done
  fi
done
