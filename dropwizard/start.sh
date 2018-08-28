#!/bin/sh
/usr/sbin/sigsci-agent &
echo "Compiling..." && cd /example
mvn clean install
echo "Running..."
java -cp classes:sigsci-module-java-1.0.2.jar -jar e1-1.0-SNAPSHOT.jar server config.yml

#/usr/sbin/sigsci-agent