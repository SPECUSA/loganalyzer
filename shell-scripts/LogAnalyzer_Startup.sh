#Start Infinidb
sudo service infinidb start

#Start Hadoop Deamons
cd /usr/local/hadoop/
bin/hadoop-daemon.sh start namenode
bin/hadoop-daemon.sh start datanode
bin/hadoop-daemon.sh start jobtracker
bin/hadoop-daemon.sh start tasktracker
