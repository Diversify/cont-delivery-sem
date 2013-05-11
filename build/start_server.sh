#!/bin/sh

NODE=$1

echo "Starting server on $NODE"

ssh ubuntu@$NODE '/opt/jetty9/bin/jetty.sh start'
