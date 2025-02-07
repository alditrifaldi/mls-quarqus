#!/bin/bash

DIR=$(pwd)

./install-jar.sh
export $(grep -v "^$" .env | grep -v "^#" | xargs)

export QUARKUS_LOG_LEVEL=INFO
mvn clean quarkus:dev -Ddebug=15005 -Djdk.virtualThreadScheduler.parallelism=16 -Djdk.virtualThreadScheduler.maxPoolSize=64