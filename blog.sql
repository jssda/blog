/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.7.24-log : Database - blog
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`blog` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `blog`;

/*Table structure for table `blog` */

DROP TABLE IF EXISTS `blog`;

CREATE TABLE `blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `author` varchar(32) NOT NULL,
  `title` varchar(225) NOT NULL,
  `info` text,
  `type` varchar(32) DEFAULT NULL COMMENT '类别',
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `visitcount` int(11) DEFAULT NULL COMMENT '访问次数',
  `content` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `title` (`title`),
  KEY `author` (`author`),
  KEY `type` (`type`),
  CONSTRAINT `blog_ibfk_1` FOREIGN KEY (`author`) REFERENCES `user` (`name`),
  CONSTRAINT `blog_ibfk_2` FOREIGN KEY (`type`) REFERENCES `type` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=203 DEFAULT CHARSET=utf8;

/*Data for the table `blog` */

insert  into `blog`(`id`,`author`,`title`,`info`,`type`,`createtime`,`updatetime`,`visitcount`,`content`) values (3,'jssd','测试1','这是个测试, JAVA语言','java','2018-11-11 18:07:44','2018-11-22 15:03:59',8,'这是个JAVA语言的测试\r\n\r\npublic static void main(String args[]) {\r\n	System.out.println(\"Hello\");\r\n}'),(4,'jssd','测试2','这是个测试, c语言','c','2018-11-22 18:09:09','2018-11-22 15:03:55',12,'这是个c语言的测试\r\n\r\n#include <stdio.h>\r\nint main() {\r\n printf(\"Hello\");\r\n return 0;\r\n}'),(5,'jssd','测试标题1','这只是测试1的测试信息, 类型为c++语言','c++','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'#include <iostream>int main() {	cout << \"hello world\" << endl;	return 0;}'),(6,'jssd','测试标题2','这只是测试2的测试信息, 类型为Java语言','java','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'public static void main(String args[]) {	System.out.println(\"Hello World\");}'),(8,'jssd','测试标题4','这只是测试4的测试信息, 类型为c语言','C','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'#include <stdio.h>int main() {	printf(\"Hello World!\\n\",);}'),(9,'jssd','测试标题5','这只是测试5的测试信息, 类型为c++语言','c++','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'#include <iostream>int main() {	cout << \"hello world\" << endl;	return 0;}'),(10,'jssd','测试标题6','这只是测试6的测试信息, 类型为Java语言','java','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'public static void main(String args[]) {	System.out.println(\"Hello World\");}'),(12,'jssd','测试标题8','这只是测试8的测试信息, 类型为c语言','C','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'#include <stdio.h>int main() {	printf(\"Hello World!\\n\",);}'),(13,'jssd','测试标题9','这只是测试9的测试信息, 类型为c++语言','c++','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'#include <iostream>int main() {	cout << \"hello world\" << endl;	return 0;}'),(14,'jssd','测试标题10','这只是测试10的测试信息, 类型为Java语言','java','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'public static void main(String args[]) {	System.out.println(\"Hello World\");}'),(16,'jssd','测试标题12','这只是测试12的测试信息, 类型为c语言','C','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'#include <stdio.h>int main() {	printf(\"Hello World!\\n\",);}'),(17,'jssd','测试标题13','这只是测试13的测试信息, 类型为c++语言','c++','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'#include <iostream>int main() {	cout << \"hello world\" << endl;	return 0;}'),(18,'jssd','测试标题14','这只是测试14的测试信息, 类型为Java语言','java','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'public static void main(String args[]) {	System.out.println(\"Hello World\");}'),(20,'jssd','测试标题16','这只是测试16的测试信息, 类型为c语言','C','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'#include <stdio.h>int main() {	printf(\"Hello World!\\n\",);}'),(21,'jssd','测试标题17','这只是测试17的测试信息, 类型为c++语言','c++','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'#include <iostream>int main() {	cout << \"hello world\" << endl;	return 0;}'),(22,'jssd','测试标题18','这只是测试18的测试信息, 类型为Java语言','java','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'public static void main(String args[]) {	System.out.println(\"Hello World\");}'),(24,'jssd','测试标题20','这只是测试20的测试信息, 类型为c语言','C','2018-11-24 06:57:17','2018-11-24 07:06:51',1,'#include <stdio.h>int main() {	printf(\"Hello World!\\n\",);}'),(25,'jssd','测试标题21','这只是测试21的测试信息, 类型为c++语言','c++','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'#include <iostream>int main() {	cout << \"hello world\" << endl;	return 0;}'),(26,'jssd','测试标题22','这只是测试22的测试信息, 类型为Java语言','java','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'public static void main(String args[]) {	System.out.println(\"Hello World\");}'),(28,'jssd','测试标题24','这只是测试24的测试信息, 类型为c语言','C','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'#include <stdio.h>int main() {	printf(\"Hello World!\\n\",);}'),(29,'jssd','测试标题25','这只是测试25的测试信息, 类型为c++语言','c++','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'#include <iostream>int main() {	cout << \"hello world\" << endl;	return 0;}'),(30,'jssd','测试标题26','这只是测试26的测试信息, 类型为Java语言','java','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'public static void main(String args[]) {	System.out.println(\"Hello World\");}'),(32,'jssd','测试标题28','这只是测试28的测试信息, 类型为c语言','C','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'#include <stdio.h>int main() {	printf(\"Hello World!\\n\",);}'),(33,'jssd','测试标题29','这只是测试29的测试信息, 类型为c++语言','c++','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'#include <iostream>int main() {	cout << \"hello world\" << endl;	return 0;}'),(34,'jssd','测试标题30','这只是测试30的测试信息, 类型为Java语言','java','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'public static void main(String args[]) {	System.out.println(\"Hello World\");}'),(36,'jssd','测试标题32','这只是测试32的测试信息, 类型为c语言','C','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'#include <stdio.h>int main() {	printf(\"Hello World!\\n\",);}'),(37,'jssd','测试标题33','这只是测试33的测试信息, 类型为c++语言','c++','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'#include <iostream>int main() {	cout << \"hello world\" << endl;	return 0;}'),(38,'jssd','测试标题34','这只是测试34的测试信息, 类型为Java语言','java','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'public static void main(String args[]) {	System.out.println(\"Hello World\");}'),(40,'jssd','测试标题36','这只是测试36的测试信息, 类型为c语言','C','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'#include <stdio.h>int main() {	printf(\"Hello World!\\n\",);}'),(41,'jssd','测试标题37','这只是测试37的测试信息, 类型为c++语言','c++','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'#include <iostream>int main() {	cout << \"hello world\" << endl;	return 0;}'),(42,'jssd','测试标题38','这只是测试38的测试信息, 类型为Java语言','java','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'public static void main(String args[]) {	System.out.println(\"Hello World\");}'),(44,'jssd','测试标题40','这只是测试40的测试信息, 类型为c语言','C','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'#include <stdio.h>int main() {	printf(\"Hello World!\\n\",);}'),(45,'jssd','测试标题41','这只是测试41的测试信息, 类型为c++语言','c++','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'#include <iostream>int main() {	cout << \"hello world\" << endl;	return 0;}'),(46,'jssd','测试标题42','这只是测试42的测试信息, 类型为Java语言','java','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'public static void main(String args[]) {	System.out.println(\"Hello World\");}'),(48,'jssd','测试标题44','这只是测试44的测试信息, 类型为c语言','C','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'#include <stdio.h>int main() {	printf(\"Hello World!\\n\",);}'),(49,'jssd','测试标题45','这只是测试45的测试信息, 类型为c++语言','c++','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'#include <iostream>int main() {	cout << \"hello world\" << endl;	return 0;}'),(50,'jssd','测试标题46','这只是测试46的测试信息, 类型为Java语言','java','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'public static void main(String args[]) {	System.out.println(\"Hello World\");}'),(52,'jssd','测试标题48','这只是测试48的测试信息, 类型为c语言','C','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'#include <stdio.h>int main() {	printf(\"Hello World!\\n\",);}'),(53,'jssd','测试标题49','这只是测试49的测试信息, 类型为c++语言','c++','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'#include <iostream>int main() {	cout << \"hello world\" << endl;	return 0;}'),(54,'jssd','测试标题50','这只是测试50的测试信息, 类型为Java语言','java','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'public static void main(String args[]) {	System.out.println(\"Hello World\");}'),(56,'jssd','测试标题52','这只是测试52的测试信息, 类型为c语言','C','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'#include <stdio.h>int main() {	printf(\"Hello World!\\n\",);}'),(57,'jssd','测试标题53','这只是测试53的测试信息, 类型为c++语言','c++','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'#include <iostream>int main() {	cout << \"hello world\" << endl;	return 0;}'),(58,'jssd','测试标题54','这只是测试54的测试信息, 类型为Java语言','java','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'public static void main(String args[]) {	System.out.println(\"Hello World\");}'),(60,'jssd','测试标题56','这只是测试56的测试信息, 类型为c语言','C','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'#include <stdio.h>int main() {	printf(\"Hello World!\\n\",);}'),(61,'jssd','测试标题57','这只是测试57的测试信息, 类型为c++语言','c++','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'#include <iostream>int main() {	cout << \"hello world\" << endl;	return 0;}'),(62,'jssd','测试标题58','这只是测试58的测试信息, 类型为Java语言','java','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'public static void main(String args[]) {	System.out.println(\"Hello World\");}'),(64,'jssd','测试标题60','这只是测试60的测试信息, 类型为c语言','C','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'#include <stdio.h>int main() {	printf(\"Hello World!\\n\",);}'),(65,'jssd','测试标题61','这只是测试61的测试信息, 类型为c++语言','c++','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'#include <iostream>int main() {	cout << \"hello world\" << endl;	return 0;}'),(66,'jssd','测试标题62','这只是测试62的测试信息, 类型为Java语言','java','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'public static void main(String args[]) {	System.out.println(\"Hello World\");}'),(68,'jssd','测试标题64','这只是测试64的测试信息, 类型为c语言','C','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'#include <stdio.h>int main() {	printf(\"Hello World!\\n\",);}'),(69,'jssd','测试标题65','这只是测试65的测试信息, 类型为c++语言','c++','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'#include <iostream>int main() {	cout << \"hello world\" << endl;	return 0;}'),(70,'jssd','测试标题66','这只是测试66的测试信息, 类型为Java语言','java','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'public static void main(String args[]) {	System.out.println(\"Hello World\");}'),(72,'jssd','测试标题68','这只是测试68的测试信息, 类型为c语言','C','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'#include <stdio.h>int main() {	printf(\"Hello World!\\n\",);}'),(73,'jssd','测试标题69','这只是测试69的测试信息, 类型为c++语言','c++','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'#include <iostream>int main() {	cout << \"hello world\" << endl;	return 0;}'),(74,'jssd','测试标题70','这只是测试70的测试信息, 类型为Java语言','java','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'public static void main(String args[]) {	System.out.println(\"Hello World\");}'),(76,'jssd','测试标题72','这只是测试72的测试信息, 类型为c语言','C','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'#include <stdio.h>int main() {	printf(\"Hello World!\\n\",);}'),(77,'jssd','测试标题73','这只是测试73的测试信息, 类型为c++语言','c++','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'#include <iostream>int main() {	cout << \"hello world\" << endl;	return 0;}'),(78,'jssd','测试标题74','这只是测试74的测试信息, 类型为Java语言','java','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'public static void main(String args[]) {	System.out.println(\"Hello World\");}'),(80,'jssd','测试标题76','这只是测试76的测试信息, 类型为c语言','C','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'#include <stdio.h>int main() {	printf(\"Hello World!\\n\",);}'),(81,'jssd','测试标题77','这只是测试77的测试信息, 类型为c++语言','c++','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'#include <iostream>int main() {	cout << \"hello world\" << endl;	return 0;}'),(82,'jssd','测试标题78','这只是测试78的测试信息, 类型为Java语言','java','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'public static void main(String args[]) {	System.out.println(\"Hello World\");}'),(84,'jssd','测试标题80','这只是测试80的测试信息, 类型为c语言','C','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'#include <stdio.h>int main() {	printf(\"Hello World!\\n\",);}'),(85,'jssd','测试标题81','这只是测试81的测试信息, 类型为c++语言','c++','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'#include <iostream>int main() {	cout << \"hello world\" << endl;	return 0;}'),(86,'jssd','测试标题82','这只是测试82的测试信息, 类型为Java语言','java','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'public static void main(String args[]) {	System.out.println(\"Hello World\");}'),(88,'jssd','测试标题84','这只是测试84的测试信息, 类型为c语言','C','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'#include <stdio.h>int main() {	printf(\"Hello World!\\n\",);}'),(89,'jssd','测试标题85','这只是测试85的测试信息, 类型为c++语言','c++','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'#include <iostream>int main() {	cout << \"hello world\" << endl;	return 0;}'),(90,'jssd','测试标题86','这只是测试86的测试信息, 类型为Java语言','java','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'public static void main(String args[]) {	System.out.println(\"Hello World\");}'),(92,'jssd','测试标题88','这只是测试88的测试信息, 类型为c语言','C','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'#include <stdio.h>int main() {	printf(\"Hello World!\\n\",);}'),(93,'jssd','测试标题89','这只是测试89的测试信息, 类型为c++语言','c++','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'#include <iostream>int main() {	cout << \"hello world\" << endl;	return 0;}'),(94,'jssd','测试标题90','这只是测试90的测试信息, 类型为Java语言','java','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'public static void main(String args[]) {	System.out.println(\"Hello World\");}'),(96,'jssd','测试标题92','这只是测试92的测试信息, 类型为c语言','C','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'#include <stdio.h>int main() {	printf(\"Hello World!\\n\",);}'),(97,'jssd','测试标题93','这只是测试93的测试信息, 类型为c++语言','c++','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'#include <iostream>int main() {	cout << \"hello world\" << endl;	return 0;}'),(98,'jssd','测试标题94','这只是测试94的测试信息, 类型为Java语言','java','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'public static void main(String args[]) {	System.out.println(\"Hello World\");}'),(100,'jssd','测试标题96','这只是测试96的测试信息, 类型为c语言','C','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'#include <stdio.h>int main() {	printf(\"Hello World!\\n\",);}'),(101,'jssd','测试标题97','这只是测试97的测试信息, 类型为c++语言','c++','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'#include <iostream>int main() {	cout << \"hello world\" << endl;	return 0;}'),(102,'jssd','测试标题98','这只是测试98的测试信息, 类型为Java语言','java','2018-11-24 06:57:17','2018-11-24 06:57:17',0,'public static void main(String args[]) {	System.out.println(\"Hello World\");}');

/*Table structure for table `type` */

DROP TABLE IF EXISTS `type`;

CREATE TABLE `type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `type` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `type` */

insert  into `type`(`id`,`type`) values (2,'c'),(3,'c++'),(1,'java'),(9,'javaEE'),(5,'javaweb'),(7,'mysql'),(4,'python'),(6,'sql'),(8,'sqlserver'),(11,'心情'),(10,'随笔');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

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
  PRIMARY KEY (`id`,`name`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`password`,`gender`,`age`,`telephone`,`email`,`introduction`,`createtime`,`updatetime`) values (3,'jssd','123456','man',20,'15188875022','1624022009@qq.com','就是没有想好	','2018-11-06 22:40:16','2018-11-25 07:46:43'),(22,'jssda','8888','man',0,'','',NULL,'2018-11-08 07:18:41','2018-11-08 07:18:41'),(24,'liu','1111','man',0,'123456789','1234568@qq.com',NULL,'2018-11-08 09:21:54','2018-11-08 09:21:54'),(25,'liuhao','123456','man',0,'17633330626','965103066@qq.com',NULL,'2018-11-10 02:31:25','2018-11-10 02:31:25');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
