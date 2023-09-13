#!/bin/bash

docker-compose -f ./composes/docker-compose-mongo.yml down
docker-compose -f ./composes/docker-compose-kafka.yml down
docker network rm eagerminds_hotel
