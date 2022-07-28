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

 Date: 19/08/2021 22:53:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cw_user_courseware
-- ----------------------------
DROP TABLE IF EXISTS `cw_user_courseware`;
CREATE TABLE `cw_user_courseware`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `user_id` int(0) NOT NULL,
  `cw_id` int(0) NOT NULL,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `cw_user_courseware_cw_courseware_id_fk`(`cw_id`) USING BTREE,
  INDEX `cw_user_courseware_user_id_fk`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cw_user_courseware
-- ----------------------------
INSERT INTO `cw_user_courseware` VALUES (4, 5, 4, '2021-08-07 18:38:44');
INSERT INTO `cw_user_courseware` VALUES (5, 5, 1, '2021-08-07 18:38:46');

SET FOREIGN_KEY_CHECKS = 1;
