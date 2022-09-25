/*
 Navicat Premium Data Transfer

 Source Server         : 我的电脑
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : cake

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 24/09/2022 00:30:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cakelist
-- ----------------------------
DROP TABLE IF EXISTS `cakelist`;
CREATE TABLE `cakelist`  (
  `c_id` int NOT NULL AUTO_INCREMENT,
  `c_name` varchar(45) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `c_price` float NOT NULL,
  `c_size` int NOT NULL,
  `c_type` int NOT NULL,
  PRIMARY KEY (`c_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cakelist
-- ----------------------------

-- ----------------------------
-- Table structure for coupon
-- ----------------------------
DROP TABLE IF EXISTS `coupon`;
CREATE TABLE `coupon`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '优惠券表ID',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '优惠券名称',
  `type` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '优惠券类型',
  `coupon_price` decimal(10, 2) NOT NULL COMMENT '兑换的优惠券面值',
  `use_min_price` decimal(10, 2) NOT NULL COMMENT '最低消费多少金额可用优惠券',
  `coupon_time` int NOT NULL COMMENT '优惠券有效期限（单位：天）',
  `status` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '状态（已发布，未发布）',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `end_time` datetime NOT NULL COMMENT '结束时间',
  `cake_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '关联的蛋糕名字',
  `amount` int NULL DEFAULT NULL COMMENT '发布数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '优惠券表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of coupon
-- ----------------------------
INSERT INTO `coupon` VALUES (1, '全场通用券', '普通券', 2.00, 10.00, 100, '已发布', '2022-10-01 00:00:00', '2022-10-01 00:00:00', '无', 55);
INSERT INTO `coupon` VALUES (2, '今日特惠券', '普通券', 5.00, 20.00, 100, '未发布', '2022-09-23 16:10:28', '2022-09-30 18:59:38', '无', 10);

-- ----------------------------
-- Table structure for coupon_record
-- ----------------------------
DROP TABLE IF EXISTS `coupon_record`;
CREATE TABLE `coupon_record`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '优惠券发放记录id',
  `user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '优惠券所属用户',
  `coupon_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '优惠券名称',
  `coupon_price` decimal(8, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '优惠券的面值',
  `use_min_price` decimal(8, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '最低消费多少金额可用优惠券',
  `create_time` datetime NOT NULL COMMENT '优惠券创建时间',
  `end_time` datetime NOT NULL COMMENT '优惠券结束时间',
  `get_type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'send' COMMENT '获取方式',
  `status` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '状态（0：未使用，1：已使用, 2:已过期）',
  `is_fail` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '是否可用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '优惠券发放记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of coupon_record
-- ----------------------------

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `o_id` int NOT NULL,
  `uid` int NULL DEFAULT NULL,
  `c_id` int NULL DEFAULT NULL,
  `o_PAOtime` datetime NULL DEFAULT NULL COMMENT '下单时间',
  `o_Stime` datetime NULL DEFAULT NULL COMMENT '签收时间',
  `o_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '总价',
  `o_count` int NULL DEFAULT NULL COMMENT '蛋糕数量',
  PRIMARY KEY (`o_id`) USING BTREE,
  INDEX `c_id`(`c_id`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  CONSTRAINT `c_id` FOREIGN KEY (`c_id`) REFERENCES `cakelist` (`c_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `uid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
 `uId` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
 `uName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名字',
 `uPassword` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
 `uIdCard` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '身份证',
 `uRegistrationTime` datetime NOT NULL COMMENT '注册时间',
 `uAddress` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '地址',
 PRIMARY KEY (`uId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- Records of user
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
