/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50721
Source Host           : 192.168.1.163:3306
Source Database       : zhuheng

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-04-10 17:09:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for gmn_user
-- ----------------------------
DROP TABLE IF EXISTS `gmn_user`;
CREATE TABLE `gmn_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL COMMENT '用户名称',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `sex` char(1) DEFAULT NULL COMMENT '性别',
  `address` varchar(256) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gmn_user
-- ----------------------------
INSERT INTO `gmn_user` VALUES ('1', 'zhuheng', '2018-04-09', '男', '北京海淀区');
INSERT INTO `gmn_user` VALUES ('27', 'SwordGod', null, null, null);

-- ----------------------------
-- Table structure for sjl22_api_command
-- ----------------------------
DROP TABLE IF EXISTS `sjl22_api_command`;
CREATE TABLE `sjl22_api_command` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `describe` varchar(255) DEFAULT NULL,
  `command` varchar(100) DEFAULT NULL,
  `request` varchar(40960) DEFAULT NULL,
  `response` varchar(4096) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_user` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sjl22_api_command
-- ----------------------------
INSERT INTO `sjl22_api_command` VALUES ('1', 'sjl22_Info', 'NC', 'NC', 'ND0093A196A2FC6C82B6CN1706-00000127-C3MG06.99ERE20.22EJK04.55EIC04.99EIS05.25E', '2018-04-08 15:00:00', 'zhuheng');
