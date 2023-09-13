#!/bin/bash

docker network create eagerminds_hotel
docker-compose -f ./composes/docker-compose-kafka.yml up -d
docker-compose -f ./composes/docker-compose-mongo.yml up -d