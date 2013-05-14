#!/bin/sh
SERVICE="mysql"
pwprompt=" "

if ps ax | grep -v grep | grep $SERVICE > /dev/null
then
    read -p "Enter username   : " username
    read -p "Enter IP Address : " ip
    sudo /usr/local/Calpont/mysql/bin/mysql --defaults-file=/usr/local/Calpont/mysql/my.cnf --user root $pwprompt mysql -e "REVOKE ALL PRIVILEGES ON log.* FROM $username@'$ip';"
    sudo /usr/local/Calpont/mysql/bin/mysql --defaults-file=/usr/local/Calpont/mysql/my.cnf --user root $pwprompt mysql -e "REVOKE ALL PRIVILEGES ON infinidb_vtable.* FROM $username@'$ip';"
    sudo /usr/local/Calpont/mysql/bin/mysql --defaults-file=/usr/local/Calpont/mysql/my.cnf --user root $pwprompt mysql -e "delete from mysql.tbl_granted_users where username='$username' and ip='$ip';"
    echo "Privileges revoked from $username@$ip with password $password"
else
    echo "$SERVICE is not running"
fi
