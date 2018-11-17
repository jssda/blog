# blog

## 简单介绍

大三BS架构课设

一个简单的博客系统

没有使用任何框架 mvc架构分层



## 需求分析

1. 用户可以登陆注册
2. 用户可以修改个人的信息
3. 
4. 用户可以发表文章
5. 文章可修改
6. 用户可以i浏览别人的文章
7. 文章可分类
8. 

## 数据库设计

### 用户表

1. user表

```mysql
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL COMMENT '用户姓名',
  `password` varchar(255) NOT NULL COMMENT '用户密码',
  `gender` varchar(16) DEFAULT NULL COMMENT '性别',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `telephone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `introduction` varchar(255) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
```



2. 博客信息表


```mysql
CREATE TABLE `blogtext` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `author` varchar(32) NOT NULL,
  `title` varchar(225) NOT NULL,
  `info` text,
  `type` varchar(32) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `visitcount` int(11) DEFAULT NULL COMMENT '访问次数',
  `content` text,
  PRIMARY KEY (`id`),
  KEY `author` (`author`),
  CONSTRAINT `blogtext_ibfk_1` FOREIGN KEY (`author`) REFERENCES `user` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

3. 文章分类表

```mysql
CREATE TABLE `type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `type` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
```

