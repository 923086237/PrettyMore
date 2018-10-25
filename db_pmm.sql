/*
 Navicat MySQL Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : db_pmm

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 25/10/2018 09:15:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `t_dictionary`;
CREATE TABLE `t_dictionary`  (
  `id` int(11) NOT NULL COMMENT '序号',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_dictionary
-- ----------------------------
INSERT INTO `t_dictionary` VALUES (1010, '有效');
INSERT INTO `t_dictionary` VALUES (1011, '无效');
INSERT INTO `t_dictionary` VALUES (2010, '审核通过');
INSERT INTO `t_dictionary` VALUES (2011, '审核拒绝');
INSERT INTO `t_dictionary` VALUES (7010, '注册');
INSERT INTO `t_dictionary` VALUES (7011, '初始化用户');
INSERT INTO `t_dictionary` VALUES (7012, '修改用户');
INSERT INTO `t_dictionary` VALUES (7013, '审核结果');

-- ----------------------------
-- Table structure for t_idcard
-- ----------------------------
DROP TABLE IF EXISTS `t_idcard`;
CREATE TABLE `t_idcard`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `cardno` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `fontimgurl` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '正面',
  `reverseimgurl` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '反面',
  `handimgurl` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手持',
  `check` int(11) NULL DEFAULT NULL COMMENT '审核状态 ',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '序号 字符串',
  `phone` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号 唯一',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码  密文',
  `type` int(11) NULL DEFAULT NULL COMMENT '用户类型 1 借款人 2 出借人',
  `flag` int(11) NULL DEFAULT NULL COMMENT '标记位  字典表 1010-1011',
  PRIMARY KEY (`no`) USING BTREE,
  UNIQUE INDEX `phone`(`phone`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_userdetail
-- ----------------------------
DROP TABLE IF EXISTS `t_userdetail`;
CREATE TABLE `t_userdetail`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `uno` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户编号',
  `realname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '真实姓名',
  `nickname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `sex` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `birthday` date NULL DEFAULT NULL COMMENT '出生日期',
  `cid` int(11) NULL DEFAULT NULL COMMENT '身份证表id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_useregister
-- ----------------------------
DROP TABLE IF EXISTS `t_useregister`;
CREATE TABLE `t_useregister`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uno` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `ip` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ip地址',
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对应的地址',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_userlog
-- ----------------------------
DROP TABLE IF EXISTS `t_userlog`;
CREATE TABLE `t_userlog`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户编号',
  `type` int(11) NOT NULL COMMENT '类型',
  `msg` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '日志内容',
  `data` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
