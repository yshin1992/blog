create database blog charset = utf8;

use blog;

create table user(
id int auto_increment comment '自增ID',
loginName nvarchar(10) not null comment '登录用户名',
passwd char(32) not null comment '登录密码',
roleId int not null default 1 comment '角色ID',
createTime timestamp not null comment '用户创建时间',
status bit default 1 comment '用户有效位标识',
primary key(id)
)default charset=utf8,engine=InnoDB;

alter table user comment '用户表';

insert into user(loginName,passwd,createTime) values('闫帅','yshin1992',now()),('艾成龙','123456',now()),
('张尧','123456',now()),('丁亚飞','123456',now()),('林泽宇','123456',now()),('童鑫','123456',now());

create table artical_type(
id smallint auto_increment comment '文章类型自增ID',
typeName nvarchar(50) not null comment '文章类型名称',
parentId smallint not null comment '文章父类型ID',
status bit default 1 comment '文章类型有效位标识',
primary key(id),
foreign key(parentId) references artical_type(id)
) default charset=utf8 engine=InnoDB;

alter table artical_type comment '文章类型表';

create table artical(
id int auto_increment comment '文章ID',
authorId int comment '作者ID',
typeId smallint comment '文章类型ID',
title nvarchar(100) not null comment '文章标题',
createTime timestamp not null comment '文章创建时间',
status bit default 1 comment '文章有效位标识',
primary key(id),
foreign key(authorId) references user(id),
foreign key(typeId) references artical_type(id)
)default charset=utf8 engine=InnoDB;

alter table artical comment '文章表';
