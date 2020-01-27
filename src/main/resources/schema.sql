create table post (
idx BIGINT not null AUTO_INCREMENT PRIMARY KEY,
content VARCHAR(255) not null,
title VARCHAR(30) not null,
user_idx BIGINT not null);

create table users (
user_idx BIGINT not null AUTO_INCREMENT PRIMARY KEY,
user_id VARCHAR(20) not null,
user_pw VARCHAR(20) not null,
user_name VARCHAR(20) not null,
created_time timestamp)