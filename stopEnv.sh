#!/bin/bash

docker-compose -p mongodb-stack down
docker-compose -p kafka-stack down
docker network rm eagerminds_hotel
