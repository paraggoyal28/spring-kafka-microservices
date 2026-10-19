# spring-kafka-project
A project to learn spring with kafka

# Commands to connect to Kafka message broker

download latest apache-kafka binary distribution
cd into the apache-kafka directory

## Generate a Kakfa Cluster ID
KAFKA_CLUSTER_ID="$(bin/kafka-storage.sh random-uuid)"

## Format log directories
bin/kafka-storage.sh format --standalone -t $KAFKA_CLUSTER_ID -c config/server.properties

## Start Kafka server
bin/kafka-server-start.sh config/server.properties

## Create a kafka topic
bin/kafka-topics.sh --create --topic quickstart-events --bootstrap-server localhost:9092

## Create a kafka producer
bin/kafka-console-producer.sh --topic quickstart-events --bootstrap-server localhost:9092

## Create a kakfa consumer
bin/kafka-console-consumer.sh --topic quickstart-events --from-beginning --bootstrap-server localhost:9092
