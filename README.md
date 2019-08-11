# Login App
This is a web app login prototype. Frontend is deployed in Angular2+ and Backend is deployed in Java wiht spring boot framework. 

# Getting Starteg

Is necesary have java [Install java](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) and maven [Install maven](https://maven.apache.org/install.html) repository configured in your machine.

For Front end ins nesesary install nodejs an Angular [Install Angular](https://angular.io/guide/setup-local)

## For launch server for test
```
cd <PROYECT_PATH>/server/
mvn spring-boot:run
```
This command deploy application in url localhost:8080 

## For launch server for test
```
cd <PROYECT_PATH>/frontEnd/
ng serve --proxy-config proxy.conf.json

```
This command deploy application in url localhost:4200 and conected with server application through localhost:8080 


# Despliegue desde docker-compose

Se requiere tener instalado doker y docker compose

1. Se construyen las imagenes de las dos aplicaciones

```
docker build -t fe-login-app:0.0.1 frontEnd/
```
```
docker build -t app-login:0.0.1 server/
```
2. se despligua el stack desde docker-compose
```
docker-compose up -d
```

