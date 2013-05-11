#!/bin/sh

NODE=$1

echo "Starting server on $NODE"

ssh $NODE '/opt/jetty9/bin/jetty.sh start'
