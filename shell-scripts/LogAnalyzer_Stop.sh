#Stop Infinidb
sudo service infinidb stop

#Stop Hadoop Deamons
cd /usr/local/hadoop/
bin/hadoop-daemon.sh stop namenode
bin/hadoop-daemon.sh stop datanode
bin/hadoop-daemon.sh stop jobtracker
bin/hadoop-daemon.sh stop tasktracker
