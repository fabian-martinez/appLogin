FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG TARGET=target
COPY ${TARGET}/loginapp-0.0.1-SNAPSHOT.jar /app/loginapp-0.0.1-SNAPSHOT.jar
COPY ${TARGET}/classes /app/classes
CMD chmod -x /app/loginapp-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/app/loginapp-0.0.1-SNAPSHOT.jar"]
