#!/bin/bash
DIR=$(pwd)
export $(grep -v "^$" docker_env.env | grep -v "^#" | xargs)

export DEBUG=15005
export QUARKUS_LOG_LEVEL=INFO

PROJECT_VERSION=$(mvn help:evaluate -Dexpression=project.version -q -DforceStdout) || exit
echo "project version: $PROJECT_VERSION"
ARTIFACT_ID=$(mvn help:evaluate -Dexpression=project.artifactId -q -DforceStdout) || exit
echo "project artifactId: $ARTIFACT_ID"
GROUP_ID=$(mvn help:evaluate -Dexpression=project.groupId -q -DforceStdout) || exit
echo "project groupId: $GROUP_ID"

mvn clean install -DskipTests \
                  -Dquarkus.container-image.build=true \
                  -Dquarkus.profile=dev \
                  -Dquarkus.container-image.group=$GROUP_ID \
                  -Dquarkus.container-image.name=$ARTIFACT_ID \
                  -Dquarkus.container-image.tag=$PROJECT_VERSION

docker build -f src/main/docker/Dockerfile.jvm -t $GROUP_ID/$ARTIFACT_ID:$PROJECT_VERSION .
docker tag $GROUP_ID/$ARTIFACT_ID:$PROJECT_VERSION $GROUP_ID/$ARTIFACT_ID:latest