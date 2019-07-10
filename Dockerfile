FROM       ubuntu:16.04
MAINTAINER Docker

# Installation:
RUN apt-get update && apt-get install -y build-essential python3
RUN apt-get install -y python-setuptools
RUN apt-get install -y python-pip
RUN apt-get install -y nano
RUN apt-get install -y telnet
RUN apt-get install -y vim

RUN apt-get update && apt-get install -y mongodb

# Create the MongoDB data directory
RUN mkdir -p /data/db

# Create the MongoDB data directory
RUN mkdir -p /data/code

RUN pip install bottle

RUN pip install pymongo

# Expose port #27017 from the container to the host
EXPOSE 27017

# Set /usr/bin/mongod as the dockerized entry-point application
ENTRYPOINT ["/bin/bash"]
