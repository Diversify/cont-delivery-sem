#!/bin/sh

NODE=$1

fab -f build/fabfile.py -H $NODE start
