DROP DATABASE IF EXISTS db_example;
CREATE DATABASE db_example;
USE db_example;
/*
 Navicat Premium Data Transfer

 Source Server         : He
 Source Server Type    : MySQL
 Source Server Version : 80032
 Source Host           : localhost:3306
 Source Schema         : db_example

 Target Server Type    : MySQL
 Target Server Version : 80032
 File Encoding         : 65001

 Date: 18/06/2023 20:46:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart`  (
  `user_id` int(0) NOT NULL,
  `goods_id` int(0) NULL DEFAULT NULL,
  `goods_count` int(0) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES (3, 2, 3);
INSERT INTO `cart` VALUES (2, 1, 1);
INSERT INTO `cart` VALUES (2, 2, 1);
INSERT INTO `cart` VALUES (2, 3, 1);
INSERT INTO `cart` VALUES (2, 4, 1);

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `goods_id` int(0) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `goods_price` float NULL DEFAULT NULL,
  PRIMARY KEY (`goods_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, '怡宝', 2);
INSERT INTO `goods` VALUES (2, '王老吉', 5);
INSERT INTO `goods` VALUES (3, '可口可乐', 3.5);
INSERT INTO `goods` VALUES (4, '薯片', 6);
INSERT INTO `goods` VALUES (5, '冰露', 1);
INSERT INTO `goods` VALUES (6, '和其正', 4);
INSERT INTO `goods` VALUES (7, '梦龙', 8);
INSERT INTO `goods` VALUES (8, '保和丸', 15);
INSERT INTO `goods` VALUES (9, '飘柔', 28);
INSERT INTO `goods` VALUES (13, '维达', 4);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(0) NOT NULL AUTO_INCREMENT,
  `user_phone` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '12345678910');
INSERT INTO `user` VALUES (2, '13111111111');
INSERT INTO `user` VALUES (3, '13111111112');
INSERT INTO `user` VALUES (4, '131111111111');
INSERT INTO `user` VALUES (5, '13111111113');
INSERT INTO `user` VALUES (6, '13111111115');

SET FOREIGN_KEY_CHECKS = 1;
