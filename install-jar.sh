#!/bin/bash

DIR=$(pwd)

function install_jar_to_maven() {
  file=$1
  pomFile=$2
mvn install:install-file \
   -Dfile=dependencies/$file \
   -DpomFile=dependencies/$pomFile
}

DPC_LIST="quarkus-authentication quarkus-microservices-common"
for dpc in $DPC_LIST ; do
    cd "dependencies/$dpc" || exit
    mvn clean install -N
    cd $DIR
    install_jar_to_maven $dpc/deployment.jar $dpc/deployment.xml
    install_jar_to_maven $dpc/runtime.jar $dpc/runtime.xml
done

cd $DIR || exit