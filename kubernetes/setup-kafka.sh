#!/bin/bash

# Deploy Kafka to KAT
helm install my-kafka oci://registry-1.docker.io/bitnamicharts/kafka


# Create a Kafka topic and run a Kafka client to test it
kubectl run my-kafka-client --restart='Never' --image docker.io/bitnami/kafka:4.0.0-debian-12-r8 --namespace default --command -- sleep infinity
kubectl cp --namespace default client.properties my-kafka-client:/tmp/client.properties
kubectl exec --tty -i my-kafka-client --namespace default -- bash

kafka-topics.sh --create --topic myloan --bootstrap-server my-kafka.default.svc.cluster.local:9092 --command-config /tmp/client.properties
kafka-console-consumer.sh --consumer.config /tmp/client.properties --bootstrap-server my-kafka.default.svc.cluster.local:9092 --topic myloan             --from-beginning


