#!/bin/sh
echo "starting Apache..."
service apache2 start 
echo "Starting SigSci Agent..."
/usr/sbin/sigsci-agent