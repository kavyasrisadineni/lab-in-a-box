FROM ubuntu:16.04

# initial setup
RUN apt-get update && apt-get upgrade -y
RUN apt-get install -y curl apt-transport-https software-properties-common maven
RUN add-apt-repository ppa:webupd8team/java
RUN apt-get update
RUN echo "oracle-java8-installer shared/accepted-oracle-license-v1-1 select true" | debconf-set-selections

RUN apt-get -y install oracle-java8-installer

#download and unpack SigSci Agent
RUN cd /usr/sbin && curl -O https://dl.signalsciences.net/sigsci-agent/sigsci-agent_latest.tar.gz && tar -xvzf sigsci-agent_latest.tar.gz

RUN mkdir /example && mkdir /example/classes
COPY app/* /example/
COPY app/src /example/src

COPY start.sh /app/start.sh
RUN chmod +x /app/start.sh
RUN mkdir /etc/sigsci
ENTRYPOINT ["/app/start.sh"]
