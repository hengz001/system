/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50721
Source Host           : 192.168.1.163:3306
Source Database       : zhuheng

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-04-11 17:20:28
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
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gmn_user
-- ----------------------------
INSERT INTO `gmn_user` VALUES ('1', 'zhuheng', '2018-04-09', '男', '北京海淀区');
INSERT INTO `gmn_user` VALUES ('27', 'SwordGod', null, null, null);
INSERT INTO `gmn_user` VALUES ('28', 'SwordGod', null, null, null);
INSERT INTO `gmn_user` VALUES ('29', 'SwordGod', null, null, null);

-- ----------------------------
-- Table structure for sjl22_api_command
-- ----------------------------
DROP TABLE IF EXISTS `sjl22_api_command`;
CREATE TABLE `sjl22_api_command` (
  `s_id` int(11) NOT NULL AUTO_INCREMENT,
  `s_command` varchar(100) DEFAULT NULL,
  `s_request` varchar(8000) DEFAULT NULL,
  `s_response` varchar(8000) DEFAULT NULL,
  `s_describe` varchar(255) DEFAULT NULL,
  `s_update_time` datetime DEFAULT NULL,
  `s_update_user` varchar(100) DEFAULT NULL,
  `s_status` int(11) DEFAULT NULL,
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sjl22_api_command
-- ----------------------------
INSERT INTO `sjl22_api_command` VALUES ('1', 'A5', 'A5 P00 000 X 1 0 00000000000000000000000000000000', 'A600X03F79C8C1FEB888D03F79C8C1FEB888D8CA64D', '生成明文密钥', '2018-04-11 04:07:57', 'zhuheng', '1');
INSERT INTO `sjl22_api_command` VALUES ('2', 'NC', 'NC', 'ND0093A196A2FC6C82B6CN1607-00000810-H5MG06.99ERE20.22EJK04.55EIC04.99EIS05.25E', '序列号', '2018-04-11 04:08:23', 'zhuheng', '1');
