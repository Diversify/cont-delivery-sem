#!/bin/sh

NODE=$1

echo "Starting deploy to $NODE"


build/stop_server.sh $NODE

echo "Copying artifacts"
SRC=root/webroti/target/webroti-*.war
DST=/opt/jetty9/webapps/webroti.war
scp $SRC ubuntu@$NODE:$DST

build/start_server.sh $NODE
