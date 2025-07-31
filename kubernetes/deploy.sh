#!/bin/bash

CLUSTER_NAME=`kubectl config current-context`
NAMESPACE="stp-poc"
APP_VERSION="1.0.0-SNAPSHOT"

SCRIPT_DIR=$(dirname "$(readlink -f "${BASH_SOURCE[0]}")")

# build image
mvn clean package -Pdocker

# create namespace
kubectl create namespace $NAMESPACE

# push image to ACR
az acr login -n katscratch
docker tag dev.local/bamoe-apps/my-stp-poc:$APP_VERSION katscratch.azurecr.io/bamoe/stp-poc:$APP_VERSION
docker push katscratch.azurecr.io/bamoe/stp-poc:$APP_VERSION

# deploy to kubernetes
kubectl -n $NAMESPACE apply -f $SCRIPT_DIR/deployment.yaml
kubectl -n $NAMESPACE apply -f $SCRIPT_DIR/service.yaml
kubectl -n $NAMESPACE apply -f $SCRIPT_DIR/ingress.yaml

kubectl -n $NAMESPACE set image deployment/web web=katscratch.azurecr.io/bamoe/stp-poc:$APP_VERSION
