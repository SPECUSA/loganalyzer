#!/bin/sh

#Install Hadoop

echo "Starting Hadoop installation....."
sudo mkdir /usr/local/hadoop
sudo tar -xf hadoop.tar.gz -C /usr/local/hadoop/
sudo chown -R hduser:hadoop /usr/local/hadoop
sudo mkdir /var/log/hadoop
sudo chown -R hduser:hadoop /var/log/hadoop
/usr/local/hadoop/bin/hadoop namenode -format
export PATH=$PATH:/usr/local/hadoop/bin
echo 'export PATH=$PATH:/usr/local/hadoop/bin' >> /home/hduser/.bashrc



echo "Starting InfiniDB installation....."
sudo dpkg -i infiniDB/calpont_2.2.11-1_amd64.deb
sudo dpkg -i infiniDB/calpont-mysql_2.2.11-1_amd64.deb
sudo dpkg -i infiniDB/calpont-mysqld_2.2.11-1_amd64.deb
sudo /usr/local/Calpont/bin/install-infinidb.sh
sudo service infinidb start
pwprompt=" "
sudo /usr/local/Calpont/mysql/bin/mysql --defaults-file=/usr/local/Calpont/mysql/my.cnf --user root $pwprompt mysql < TBL_HTTP_LOG.sql
sudo service infinidb stop
echo "Congratulations you have sucessfully installed hadoop cluster"

