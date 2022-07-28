/*
 Navicat Premium Data Transfer

 Source Server         : test
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : courseware

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 22/08/2021 21:26:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cw_order
-- ----------------------------
DROP TABLE IF EXISTS `cw_order`;
CREATE TABLE `cw_order`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `order_sn` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cw_id` int(0) NULL DEFAULT NULL,
  `user_id` int(0) NOT NULL,
  `price` decimal(10, 2) NOT NULL,
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `pay_time` timestamp(0) NULL DEFAULT NULL,
  `is_pay` tinyint(1) NULL DEFAULT 0,
  `pay_type` int(0) NULL DEFAULT NULL COMMENT '0->小程序',
  `wx_order` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `cw_order_order_sn_index`(`order_sn`) USING BTREE,
  INDEX `cw_order_cw_courseware_id_fk`(`cw_id`) USING BTREE,
  INDEX `cw_order_user_id_fk`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
