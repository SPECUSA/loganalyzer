#!/bin/sh

echo "Starting Log Analyzer Cluster uninstallation....."
sudo rm -rf /usr/local/hadoop
sudo rm -rf /var/log/hadoop
sudo rm -rf /home/hduser/hadoop
sudo dpkg --purge calpont
sudo dpkg --purge calpont-mysql
sudo dpkg --purge calpont-mysqld
echo "Log Analyzer Cluster uninstallation completed"
