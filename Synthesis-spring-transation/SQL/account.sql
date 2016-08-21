/*
Navicat MySQL Data Transfer

Source Server         : timebusker
Source Server Version : 50710
Source Host           : 127.0.0.1:3306
Source Database       : timebusker

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2016-08-16 16:37:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `money` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
