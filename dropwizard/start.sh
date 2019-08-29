#!/bin/sh
/usr/sbin/sigsci-agent &
echo "Compiling..." && cd /example
mvn clean install
echo "Running..."
java -jar /example/target/e1-1.0-SNAPSHOT.jar server config.yml

