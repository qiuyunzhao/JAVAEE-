/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : javaspeek300

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-11-21 22:29:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL,
  `pwd` varchar(30) DEFAULT NULL,
  `regTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `data` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '邱云钊', '123', '2019-05-16 00:00:00', null, null);
INSERT INTO `t_user` VALUES ('2', 'zhangsan', '666', '2019-07-21 10:54:16', null, null);
INSERT INTO `t_user` VALUES ('3', 'lisi', '666', '2019-07-20 21:53:18', null, null);
INSERT INTO `t_user` VALUES ('4', '张三', '666', '2019-07-21 10:54:23', null, null);
INSERT INTO `t_user` VALUES ('5', '李四', '666', '2019-07-21 10:54:30', null, null);
