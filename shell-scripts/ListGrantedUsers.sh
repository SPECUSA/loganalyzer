#!/bin/sh
sudo /usr/local/Calpont/mysql/bin/mysql --defaults-file=/usr/local/Calpont/mysql/my.cnf --user root $pwprompt mysql -e "select * from mysql.tbl_granted_users;"
