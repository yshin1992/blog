create database blog charset = utf8;

use blog;

create table user(
id int auto_increment comment '自增ID',
login_name nvarchar(10) not null comment '登录用户名',
passwd char(32) not null comment '登录密码',
role_id int not null default 1 comment '角色ID',
create_time timestamp not null comment '用户创建时间',
status bit default 1 comment '用户有效位标识',
primary key(id)
)default charset=utf8,engine=InnoDB;

alter table user comment '用户表';

insert into user(login_Name,passwd,create_time) values('闫帅','yshin1992',now()),('艾成龙','123456',now()),
('张尧','123456',now()),('丁亚飞','123456',now()),('林泽宇','123456',now()),('童鑫','123456',now());