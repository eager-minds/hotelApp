#!/bin/bash

docker-compose -p mongodb-stack down
docker-compose -p kafka-stack down
dockerNetworkRmLogs=$(docker network rm eagerminds_hotel) > /dev/null 2>&1
if [ -n "$dockerNetworkRmLogs" ]; then
  echo "removed $dockerNetworkRmLogs network"
fi
