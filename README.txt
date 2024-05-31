1. Navigate to root project folder in Terminal
2. Run: docker compose -f docker-compose.yml up -d
3. Zookeeper and Kafka should now be running.
4. Check their status by running: docker ps. If healthy, start the application.
5. Run: docker exec -it kafka /bin/sh
6. Run: cd opt
7. Type: ls, and look for the kafka with versions attached
8. Run: cd kafka_2.13-2.8.1  <- The version here depends on which Kafka you have from ls command above
9. Optional create topic locally: kafka-topics.sh --create --zookeeper zookeeper:2181 --replication-factor 1 --partitions 1 --topic <topic name>
10. To produce to given topic run: kafka-console-producer.sh --topic user_queries --bootstrap-server localhost:9092 --property "parse.key=true" --property "key.separator=:"
11. You will then be prompted to send the message, Use this format key:value. Like this: key1:How do you send a message in Kafka?