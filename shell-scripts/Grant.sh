#!/bin/sh
SERVICE="mysql"
pwprompt=" "

if ps ax | grep -v grep | grep $SERVICE > /dev/null
then
    read -p "Enter username   : " username
    read -p "Enter password   : " password 
    read -p "Enter IP Address : " ip
    sudo /usr/local/Calpont/mysql/bin/mysql --defaults-file=/usr/local/Calpont/mysql/my.cnf --user root $pwprompt mysql -e "GRANT ALL PRIVILEGES ON log.* TO $username@'$ip' IDENTIFIED BY '$password';"
    sudo /usr/local/Calpont/mysql/bin/mysql --defaults-file=/usr/local/Calpont/mysql/my.cnf --user root $pwprompt mysql -e "GRANT ALL PRIVILEGES ON infinidb_vtable.* TO $username@'$ip' IDENTIFIED BY '$password';"
    sudo /usr/local/Calpont/mysql/bin/mysql --defaults-file=/usr/local/Calpont/mysql/my.cnf --user root $pwprompt mysql -e "insert into mysql.tbl_granted_users values('$username','$password','$ip');"
    echo "Privileges granted to $username@$ip with password $password"
else
    echo "$SERVICE is not running"
fi
