#!/bin/sh

NODE=$1

echo "Stopping server on $NODE"

ssh ubuntu@$NODE '/opt/jetty9/bin/jetty.sh stop'
