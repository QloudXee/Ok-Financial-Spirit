/*
Navicat MySQL Data Transfer

Source Server         : localhost_8081
Source Server Version : 50719
Source Host           : localhost:8081
Source Database       : conduct

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-10-16 11:29:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_import
-- ----------------------------
DROP TABLE IF EXISTS `tb_import`;
CREATE TABLE `tb_import` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `inputNum` int(11) DEFAULT NULL,
  `userId` bigint(20) NOT NULL,
  `statues` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `touser` (`userId`),
  CONSTRAINT `touser` FOREIGN KEY (`userId`) REFERENCES `tb_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_import
-- ----------------------------

-- ----------------------------
-- Table structure for tb_output
-- ----------------------------
DROP TABLE IF EXISTS `tb_output`;
CREATE TABLE `tb_output` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `outputNum` int(11) DEFAULT NULL,
  `userId` bigint(20) NOT NULL,
  `statues` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `user` (`userId`),
  CONSTRAINT `user` FOREIGN KEY (`userId`) REFERENCES `tb_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_output
-- ----------------------------

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `balance` int(11) DEFAULT '0',
  `statues` int(255) DEFAULT '1',
  `email` varchar(30) DEFAULT NULL,
  `sex` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', '刘思嘉', 'lsj', '10000', '1', 'lsj@111.cpm', '男');
INSERT INTO `tb_user` VALUES ('2', '徐张立', 'xzl', '10000', '1', 'xzl@qq.com', '男');
INSERT INTO `tb_user` VALUES ('3', 'admin', '123', '0', '2', 'admin@000.com', '男');
INSERT INTO `tb_user` VALUES ('4', '111', '111', '0', '2', '111@111.com', '男');
INSERT INTO `tb_user` VALUES ('5', '陈曦', 'chenxi', '1000', '1', '781058829@qq.com', '男');
INSERT INTO `tb_user` VALUES ('6', '杨斌', '123', '1000', '1', 'yb@qq.com', '男');
INSERT INTO `tb_user` VALUES ('11', '陈珂润', 'ckr', '1000', '1', 'ckr@qq.com', '女');
INSERT INTO `tb_user` VALUES ('18', '刘颖', '111', '0', '1', 'ly@qq.com', '女');
INSERT INTO `tb_user` VALUES ('20', 'qloud', '123', '0', '1', '123@qloud.com', '男');
INSERT INTO `tb_user` VALUES ('24', '啦啦啦', 'lalala', '0', '1', 'lalala@lalala.com', '男');
INSERT INTO `tb_user` VALUES ('25', '哎嘿嘿', 'ahh1', '0', '1', 'ahh@ahh.com', '女');
