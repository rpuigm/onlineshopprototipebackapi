#!/bin/bash

set -e

cd `dirname $0`
r=`pwd`
echo $r

# Config
cd $r/ectemplate-service-config-server
echo "Starting Config Service..."
mvn -q clean spring-boot:run &

# Config
cd $r/ectemplate-service-config-server
echo "Starting Config Service..."
mvn -q clean spring-boot:run &