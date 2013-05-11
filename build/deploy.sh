#!/bin/sh

NODE=$1

echo "Starting deploy to $NODE"


./stop_server.sh $NODE

echo "Copying artifacts"
SRC=webroti/target/webroti-*.war
DST=/opt/jetty9/webapps/
scp $SRC $NODE:$DST

./start_server.sh $NODE
