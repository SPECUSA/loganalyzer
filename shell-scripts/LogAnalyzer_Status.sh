#!/bin/sh

if ps ax | grep -v grep | grep "mysql" > /dev/null
then
    echo "MySQL is running"	
else
    echo "MySQL is not running"
fi
hc=`jps | wc -l`
if [ $hc -eq 5 ]
then
    echo "Hadoop Cluster is running"
    jps
else
    echo "Hadoop Clusert is not running"
    jps
fi
