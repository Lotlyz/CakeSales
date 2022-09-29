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

 Date: 29/09/2022 18:40:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
                          `id` int NOT NULL AUTO_INCREMENT,
                          `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '名字',
                          `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
                          `flog` int NOT NULL COMMENT '有效码：1->有效；2->无效',
                          PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', '123456', 1);

-- ----------------------------
-- Table structure for cake
-- ----------------------------
DROP TABLE IF EXISTS `cake`;
CREATE TABLE `cake`  (
                         `c_id` int NOT NULL AUTO_INCREMENT,
                         `c_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '蛋糕名字',
                         `c_price` int NOT NULL COMMENT '蛋糕价格',
                         `c_size` int NOT NULL COMMENT '蛋糕尺寸',
                         `c_type` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '蛋糕类型',
                         PRIMARY KEY (`c_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cake
-- ----------------------------
INSERT INTO `cake` VALUES (1, '草莓蛋糕', 22, 4, '水果');
INSERT INTO `cake` VALUES (2, '芒果蛋糕', 55, 6, '水果');
INSERT INTO `cake` VALUES (3, '西红柿蛋糕', 33, 5, '水果');
INSERT INTO `cake` VALUES (4, '生日蛋糕', 66, 4, '生日');
INSERT INTO `cake` VALUES (5, '豪华蛋糕', 99, 6, '豪华');
INSERT INTO `cake` VALUES (6, '结婚蛋糕', 199, 8, '结婚');

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
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '优惠券表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of coupon
-- ----------------------------
INSERT INTO `coupon` VALUES (1, '全场通用券', '普通券', 2.00, 10.00, 111, '未发布', '2022-09-26 00:00:00', '2022-09-30 00:00:00', '无', 11);
INSERT INTO `coupon` VALUES (2, '今日特惠券', '普通券', 5.00, 20.00, 100, '未发布', '2022-09-23 16:10:28', '2022-09-30 18:59:38', '无', 10);
INSERT INTO `coupon` VALUES (3, '生日优惠券', '商品券', 12.00, 66.00, 100, '已发布', '2022-09-26 00:00:00', '2022-09-30 00:00:00', '生日蛋糕', 22);
INSERT INTO `coupon` VALUES (4, '草莓蛋糕券', '商品券', 4.00, 22.00, 100, '已发布', '2022-09-26 00:00:00', '2022-09-30 00:00:00', '草莓蛋糕', 45);
INSERT INTO `coupon` VALUES (5, '西红柿蛋糕券', '商品券', 5.00, 33.00, 100, '未发布', '2022-09-26 00:00:00', '2022-10-20 00:00:00', '西红柿蛋糕', 88);
INSERT INTO `coupon` VALUES (6, '豪华蛋糕券', '商品券', 16.00, 99.00, 100, '未发布', '2022-09-26 00:00:00', '2022-10-20 00:00:00', '豪华蛋糕', 8);
INSERT INTO `coupon` VALUES (8, '结婚优惠券', '商品券', 22.00, 199.00, 100, '已发布', '2022-09-10 00:00:00', '2022-09-30 00:00:00', '结婚蛋糕', 6);

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
                          `o_id` int NOT NULL AUTO_INCREMENT,
                          `userId` int NULL DEFAULT NULL,
                          `c_id` int NULL DEFAULT NULL,
                          `o_PAOtime` datetime NULL DEFAULT NULL COMMENT '下单时间',
                          `o_Stime` datetime NULL DEFAULT NULL COMMENT '签收时间',
                          `o_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '总价',
                          `o_count` int NULL DEFAULT NULL COMMENT '蛋糕数量',
                          PRIMARY KEY (`o_id`) USING BTREE,
                          INDEX `c_id`(`c_id`) USING BTREE,
                          INDEX `userId`(`userId`) USING BTREE,
                          CONSTRAINT `c_id` FOREIGN KEY (`c_id`) REFERENCES `cake` (`c_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
                          CONSTRAINT `userId` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (1, 1, 1, '2022-09-29 00:00:00', '2022-09-29 00:00:00', 22.00, 1);
INSERT INTO `order` VALUES (2, 2, 2, '2022-09-29 00:00:00', '2022-09-30 00:00:00', 22.00, 33);
INSERT INTO `order` VALUES (3, 1, 1, '2022-09-29 00:00:00', '2022-09-29 00:00:00', 22.00, 1);
INSERT INTO `order` VALUES (4, 2, 2, '2022-09-29 00:00:00', '2022-09-30 00:00:00', 22.00, 33);
INSERT INTO `order` VALUES (5, 3, 2, '2022-09-29 00:00:00', '2022-09-30 00:00:00', 55.00, 1);
INSERT INTO `order` VALUES (6, 4, 3, '2022-09-29 00:00:00', '2022-09-30 00:00:00', 33.00, 1);
INSERT INTO `order` VALUES (7, 5, 4, '2022-09-29 00:00:00', '2022-09-30 00:00:00', 12.00, 1);
INSERT INTO `order` VALUES (8, 6, 5, '2022-09-29 00:00:00', '2022-09-30 00:00:00', 99.00, 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
                         `userId` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
                         `userName` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名字',
                         `userPassword` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
                         `userIdCard` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '身份证',
                         `userRegistrationTime` datetime NOT NULL COMMENT '注册时间',
                         `userAddress` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '地址',
                         PRIMARY KEY (`userId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'CK', '123456', '666666', '2022-09-29 16:15:40', '南宁学院');
INSERT INTO `user` VALUES (2, 'LHY', '123456', '777777', '2022-09-29 16:16:18', '学生宿舍');
INSERT INTO `user` VALUES (3, '佳良', '123456', '888888', '2022-09-29 16:16:51', '卧龙岗');
INSERT INTO `user` VALUES (4, '叶子', '123456', '999999', '2022-09-29 16:17:27', '6栋');
INSERT INTO `user` VALUES (5, '雪豹', '123456', '555555', '2022-09-28 17:58:17', '叫啊');
INSERT INTO `user` VALUES (6, '阿海', '123123', '555555', '2022-09-21 17:58:58', '南宁');
INSERT INTO `user` VALUES (7, '安慰', '1231232', '2213213', '2022-09-21 17:59:21', '柳州');

SET FOREIGN_KEY_CHECKS = 1;
