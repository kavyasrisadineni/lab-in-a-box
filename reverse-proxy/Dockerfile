FROM debian:8.0

# initial setup
RUN apt-get update
RUN apt-get install -y apt-transport-https wget sed apache2
RUN wget -qO - https://apt.signalsciences.net/gpg.key | apt-key add -
RUN echo "deb https://apt.signalsciences.net/release/debian/ jessie main" > /etc/apt/sources.list.d/sigsci-release.list
RUN apt-get update

# install
RUN apt-get -y install sigsci-agent sigsci-module-apache

# configure
RUN a2enmod signalsciences

# copy app code
CMD mkdir app
#COPY app /var/www/html/

COPY start.sh /app/start.sh
RUN chmod +x /app/start.sh
COPY app/index.html /var/www/html/index.html
RUN mkdir /etc/sigsci

ENTRYPOINT ["/app/start.sh"]