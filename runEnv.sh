#!/bin/bash

docker network create eagerminds_hotel
docker-compose -f ./composes/docker-compose-kafka.yml -p kafka-stack up -d
docker-compose -f ./composes/docker-compose-mongodb.yml -p mongodb-stack up -d
