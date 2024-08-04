#!/bin/bash

set -e

cd `dirname $0`
r=`pwd`
echo $r

# Config
cd $r/ectemplate-service-config-server
echo "Starting Config Service..."
mvn -q clean spring-boot:run 

# Config
cd $r/ectemplate-servicio-eureka-server
echo "Starting Eureka Service..."
mvn -q clean spring-boot:run 

# Config
cd $r/ectemplate-service-oauth
echo "Starting Oauth Service..."
mvn -q clean spring-boot:run 

# Config
cd $r/ectemplate-servicio-peronas
echo "Starting Personas Service..."
mvn -q clean spring-boot:run 

# Config
cd $r/ectemplate-servicio-productos
echo "Starting Productos Service..."
mvn -q clean spring-boot:run 

# Config
cd $r/ectemplate-service-zuul-server
echo "Starting Zuul Service..."
mvn -q clean spring-boot:run 

# Config
cd $r/clientes-app
echo "Starting Clientes App..."
mvn -q clean spring-boot:run 