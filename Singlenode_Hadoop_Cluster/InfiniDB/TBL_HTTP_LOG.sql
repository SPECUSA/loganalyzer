create database log;

use log;

create table tbl_http_log(
client_ip varchar(20),
client_name varchar(10),
log_date date,
log_time varchar(8), 
request_method varchar(10),
url varchar(500),
status int,
bytes int
)
engine=infinidb;