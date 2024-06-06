# SpringCloud & SpringCloud Alibaba(一套标准化的微服务解决方案)

## member-service-provider-10000

```mysql
CREATE DATABASE IF NOT EXISTS e_commerce_center_db;
USE e_commerce_center_db;
CREATE TABLE `member` (
	`id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id',
	`name` VARCHAR(64) COMMENT '用户名',
	`pwd` CHAR(32) COMMENT '密码',
	`mobile` VARCHAR(20) COMMENT '手机号码',
	`email` VARCHAR(64) COMMENT '邮箱',
	`gender` TINYINT COMMENT '性别',
	PRIMARY KEY (`id`)
);

INSERT INTO `member` VALUES 
	(NULL, 'charlie', MD5('123'), '123456789545', 'charlie@gmail.com', 1),
	(NULL, 'snow', MD5('456'), '123568975520', 'snow@163.com', 0);

SELECT * FROM `member`;
```
