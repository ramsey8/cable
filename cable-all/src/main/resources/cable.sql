/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50640
 Source Host           : 10.129.12.55:3306
 Source Schema         : cable

 Target Server Type    : MySQL
 Target Server Version : 50640
 File Encoding         : 65001

 Date: 14/07/2019 20:40:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '自定id,主要供前端展示权限列表分类排序使用.',
  `menu_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '归属菜单,前端判断并展示菜单使用,',
  `menu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '菜单的中文释义',
  `permission_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '权限的代码/通配符,对应代码中@RequiresPermissions 的value',
  `permission_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '本权限的中文释义',
  `required_permission` tinyint(1) NULL DEFAULT 2 COMMENT '是否本菜单必选权限, 1.必选 2非必选 通常是\"列表\"权限是必选',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台权限表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('0', 'order', '订单管理', 'order:commit', '提交', 2);
INSERT INTO `sys_permission` VALUES ('1', 'order', '订单管理', 'order:receive', '接单', 2);
INSERT INTO `sys_permission` VALUES ('101', 'article', '文章管理', 'article:list', '列表', 1);
INSERT INTO `sys_permission` VALUES ('102', 'article', '文章管理', 'article:add', '新增', 2);
INSERT INTO `sys_permission` VALUES ('103', 'article', '文章管理', 'article:update', '修改', 2);
INSERT INTO `sys_permission` VALUES ('2', 'order', '订单管理', 'order:price', '定价', 2);
INSERT INTO `sys_permission` VALUES ('3', 'order', '订单管理', 'order:confirm', '确认', 2);
INSERT INTO `sys_permission` VALUES ('4', 'order', '订单管理', 'order:produce', '生产', 2);
INSERT INTO `sys_permission` VALUES ('601', 'user', '用户', 'user:list', '列表', 1);
INSERT INTO `sys_permission` VALUES ('602', 'user', '用户', 'user:add', '新增', 2);
INSERT INTO `sys_permission` VALUES ('603', 'user', '用户', 'user:update', '修改', 2);
INSERT INTO `sys_permission` VALUES ('701', 'role', '角色权限', 'role:list', '列表', 1);
INSERT INTO `sys_permission` VALUES ('702', 'role', '角色权限', 'role:add', '新增', 2);
INSERT INTO `sys_permission` VALUES ('703', 'role', '角色权限', 'role:update', '修改', 2);
INSERT INTO `sys_permission` VALUES ('704', 'role', '角色权限', 'role:delete', '删除', 2);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `delete_status` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '是否有效  1有效  2无效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台角色表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '管理员', '2017-11-22 16:24:34', '2017-11-22 16:24:52', '1');
INSERT INTO `sys_role` VALUES ('2', '作家', '2017-11-22 16:24:34', '2019-07-14 19:45:12', '1');
INSERT INTO `sys_role` VALUES ('3', '经理', '2017-11-22 16:28:47', '2019-07-14 19:22:01', '1');
INSERT INTO `sys_role` VALUES ('498f74f32b7448ae99f14ee72fbcfedf', '测试+', '2019-07-14 19:26:45', '2019-07-14 19:43:38', '0');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色id',
  `permission_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限id',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `delete_status` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '是否有效 1有效     2无效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色-权限关联表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('1', '2', '101', '2017-11-22 16:26:21', '2019-07-14 19:45:12', '0');
INSERT INTO `sys_role_permission` VALUES ('10', '2', '702', '2017-11-22 16:28:28', '2019-07-14 19:45:12', '0');
INSERT INTO `sys_role_permission` VALUES ('11', '2', '704', '2017-11-22 16:28:31', '2019-07-14 19:45:12', '0');
INSERT INTO `sys_role_permission` VALUES ('12', '2', '103', '2017-11-22 16:28:31', '2019-07-14 19:45:12', '0');
INSERT INTO `sys_role_permission` VALUES ('13', '3', '601', '2017-11-22 16:28:47', '2019-07-14 19:22:01', '0');
INSERT INTO `sys_role_permission` VALUES ('14', '3', '701', '2017-11-22 16:28:47', '2019-07-14 19:22:01', '0');
INSERT INTO `sys_role_permission` VALUES ('15', '3', '702', '2017-11-22 16:35:01', '2019-07-14 19:22:01', '0');
INSERT INTO `sys_role_permission` VALUES ('16', '3', '704', '2017-11-22 16:35:01', '2019-07-14 19:22:01', '0');
INSERT INTO `sys_role_permission` VALUES ('1645b902a62911e991da000c29d316eb', '3', '601', '2019-07-14 19:18:22', '2019-07-14 19:22:01', '0');
INSERT INTO `sys_role_permission` VALUES ('1645b971a62911e991da000c29d316eb', '3', '603', '2019-07-14 19:18:22', '2019-07-14 19:22:01', '0');
INSERT INTO `sys_role_permission` VALUES ('1645b97da62911e991da000c29d316eb', '3', '701', '2019-07-14 19:18:22', '2019-07-14 19:22:01', '0');
INSERT INTO `sys_role_permission` VALUES ('1645b986a62911e991da000c29d316eb', '3', '702', '2019-07-14 19:18:22', '2019-07-14 19:22:01', '0');
INSERT INTO `sys_role_permission` VALUES ('1645b98ca62911e991da000c29d316eb', '3', '704', '2019-07-14 19:18:22', '2019-07-14 19:22:01', '0');
INSERT INTO `sys_role_permission` VALUES ('1645b993a62911e991da000c29d316eb', '3', '0', '2019-07-14 19:18:22', '2019-07-14 19:22:01', '0');
INSERT INTO `sys_role_permission` VALUES ('17', '3', '102', '2017-11-22 16:35:01', '2019-07-14 19:22:01', '0');
INSERT INTO `sys_role_permission` VALUES ('18', '3', '101', '2017-11-22 16:35:01', '2019-07-14 19:22:01', '0');
INSERT INTO `sys_role_permission` VALUES ('19', '3', '603', '2017-11-22 16:35:01', '2019-07-14 19:22:01', '0');
INSERT INTO `sys_role_permission` VALUES ('1932327da62911e991da000c29d316eb', '3', '601', '2019-07-14 19:18:27', '2019-07-14 19:22:01', '0');
INSERT INTO `sys_role_permission` VALUES ('193232a4a62911e991da000c29d316eb', '3', '603', '2019-07-14 19:18:27', '2019-07-14 19:22:01', '0');
INSERT INTO `sys_role_permission` VALUES ('193232b2a62911e991da000c29d316eb', '3', '701', '2019-07-14 19:18:27', '2019-07-14 19:22:01', '0');
INSERT INTO `sys_role_permission` VALUES ('193232b9a62911e991da000c29d316eb', '3', '702', '2019-07-14 19:18:27', '2019-07-14 19:22:01', '0');
INSERT INTO `sys_role_permission` VALUES ('193232c1a62911e991da000c29d316eb', '3', '704', '2019-07-14 19:18:27', '2019-07-14 19:22:01', '0');
INSERT INTO `sys_role_permission` VALUES ('193232c7a62911e991da000c29d316eb', '3', '0', '2019-07-14 19:18:27', '2019-07-14 19:22:01', '0');
INSERT INTO `sys_role_permission` VALUES ('193232cfa62911e991da000c29d316eb', '3', '1', '2019-07-14 19:18:27', '2019-07-14 19:22:01', '0');
INSERT INTO `sys_role_permission` VALUES ('193232d5a62911e991da000c29d316eb', '3', '2', '2019-07-14 19:18:27', '2019-07-14 19:22:01', '0');
INSERT INTO `sys_role_permission` VALUES ('193232dca62911e991da000c29d316eb', '3', '3', '2019-07-14 19:18:27', '2019-07-14 19:22:01', '0');
INSERT INTO `sys_role_permission` VALUES ('193232e3a62911e991da000c29d316eb', '3', '4', '2019-07-14 19:18:27', '2019-07-14 19:22:01', '0');
INSERT INTO `sys_role_permission` VALUES ('1b2e850da62911e991da000c29d316eb', '3', '601', '2019-07-14 19:18:30', '2019-07-14 19:22:01', '0');
INSERT INTO `sys_role_permission` VALUES ('1b2e8537a62911e991da000c29d316eb', '3', '603', '2019-07-14 19:18:30', '2019-07-14 19:22:01', '0');
INSERT INTO `sys_role_permission` VALUES ('1b2e8541a62911e991da000c29d316eb', '3', '701', '2019-07-14 19:18:30', '2019-07-14 19:22:01', '0');
INSERT INTO `sys_role_permission` VALUES ('1b2e8549a62911e991da000c29d316eb', '3', '702', '2019-07-14 19:18:30', '2019-07-14 19:22:01', '0');
INSERT INTO `sys_role_permission` VALUES ('1b2e8550a62911e991da000c29d316eb', '3', '704', '2019-07-14 19:18:30', '2019-07-14 19:22:01', '0');
INSERT INTO `sys_role_permission` VALUES ('2', '2', '102', '2017-11-22 16:26:21', '2019-07-14 19:45:12', '0');
INSERT INTO `sys_role_permission` VALUES ('27a9a63ca62911e991da000c29d316eb', '3', '601', '2019-07-14 19:18:51', '2019-07-14 19:22:01', '0');
INSERT INTO `sys_role_permission` VALUES ('27a9a665a62911e991da000c29d316eb', '3', '603', '2019-07-14 19:18:51', '2019-07-14 19:22:01', '0');
INSERT INTO `sys_role_permission` VALUES ('27a9a66fa62911e991da000c29d316eb', '3', '701', '2019-07-14 19:18:51', '2019-07-14 19:22:01', '0');
INSERT INTO `sys_role_permission` VALUES ('27a9a677a62911e991da000c29d316eb', '3', '702', '2019-07-14 19:18:51', '2019-07-14 19:22:01', '0');
INSERT INTO `sys_role_permission` VALUES ('27a9a67ea62911e991da000c29d316eb', '3', '704', '2019-07-14 19:18:51', '2019-07-14 19:22:01', '0');
INSERT INTO `sys_role_permission` VALUES ('42fc5c55a62a11e991da000c29d316eb', '498f74f32b7448ae99f14ee72fbcfedf', '0', '2019-07-14 19:26:47', '2019-07-14 19:43:38', '0');
INSERT INTO `sys_role_permission` VALUES ('4c18e2d6a62a11e991da000c29d316eb', '498f74f32b7448ae99f14ee72fbcfedf', '0', '2019-07-14 19:27:02', '2019-07-14 19:43:38', '0');
INSERT INTO `sys_role_permission` VALUES ('4c18e365a62a11e991da000c29d316eb', '498f74f32b7448ae99f14ee72fbcfedf', '101', '2019-07-14 19:27:02', '2019-07-14 19:43:38', '0');
INSERT INTO `sys_role_permission` VALUES ('5', '2', '602', '2017-11-22 16:28:28', '2019-07-14 19:45:12', '0');
INSERT INTO `sys_role_permission` VALUES ('6', '2', '601', '2017-11-22 16:28:28', '2019-07-14 19:45:12', '0');
INSERT INTO `sys_role_permission` VALUES ('7', '2', '603', '2017-11-22 16:28:28', '2019-07-14 19:45:12', '0');
INSERT INTO `sys_role_permission` VALUES ('8', '2', '703', '2017-11-22 16:28:28', '2019-07-14 19:45:12', '0');
INSERT INTO `sys_role_permission` VALUES ('829f81fea62711e991da000c29d316eb', '3', '601', '2019-07-14 19:07:05', '2019-07-14 19:22:01', '0');
INSERT INTO `sys_role_permission` VALUES ('829f829da62711e991da000c29d316eb', '3', '603', '2019-07-14 19:07:05', '2019-07-14 19:22:01', '0');
INSERT INTO `sys_role_permission` VALUES ('829f82aaa62711e991da000c29d316eb', '3', '701', '2019-07-14 19:07:05', '2019-07-14 19:22:01', '0');
INSERT INTO `sys_role_permission` VALUES ('829f82b2a62711e991da000c29d316eb', '3', '702', '2019-07-14 19:07:05', '2019-07-14 19:22:01', '0');
INSERT INTO `sys_role_permission` VALUES ('829f82baa62711e991da000c29d316eb', '3', '704', '2019-07-14 19:07:05', '2019-07-14 19:22:01', '0');
INSERT INTO `sys_role_permission` VALUES ('8c1c44a3a62711e991da000c29d316eb', '3', '601', '2019-07-14 19:07:21', '2019-07-14 19:22:01', '0');
INSERT INTO `sys_role_permission` VALUES ('8c1c451aa62711e991da000c29d316eb', '3', '603', '2019-07-14 19:07:21', '2019-07-14 19:22:01', '0');
INSERT INTO `sys_role_permission` VALUES ('8c1c4526a62711e991da000c29d316eb', '3', '701', '2019-07-14 19:07:21', '2019-07-14 19:22:01', '0');
INSERT INTO `sys_role_permission` VALUES ('8c1c452ea62711e991da000c29d316eb', '3', '702', '2019-07-14 19:07:21', '2019-07-14 19:22:01', '0');
INSERT INTO `sys_role_permission` VALUES ('8c1c4535a62711e991da000c29d316eb', '3', '704', '2019-07-14 19:07:21', '2019-07-14 19:22:01', '0');
INSERT INTO `sys_role_permission` VALUES ('9', '2', '701', '2017-11-22 16:28:28', '2019-07-14 19:45:12', '0');
INSERT INTO `sys_role_permission` VALUES ('95bb12b1a62911e991da000c29d316eb', '3', '601', '2019-07-14 19:21:56', '2019-07-14 19:22:01', '0');
INSERT INTO `sys_role_permission` VALUES ('95bb135da62911e991da000c29d316eb', '3', '603', '2019-07-14 19:21:56', '2019-07-14 19:22:01', '0');
INSERT INTO `sys_role_permission` VALUES ('95bb136ea62911e991da000c29d316eb', '3', '701', '2019-07-14 19:21:56', '2019-07-14 19:22:01', '0');
INSERT INTO `sys_role_permission` VALUES ('95bb1376a62911e991da000c29d316eb', '3', '702', '2019-07-14 19:21:56', '2019-07-14 19:22:01', '0');
INSERT INTO `sys_role_permission` VALUES ('95bb137ea62911e991da000c29d316eb', '3', '704', '2019-07-14 19:21:56', '2019-07-14 19:22:01', '0');
INSERT INTO `sys_role_permission` VALUES ('95bb1386a62911e991da000c29d316eb', '3', '0', '2019-07-14 19:21:56', '2019-07-14 19:22:01', '0');
INSERT INTO `sys_role_permission` VALUES ('9893e5a2a62911e991da000c29d316eb', '3', '601', '2019-07-14 19:22:01', '2019-07-14 19:22:01', '1');
INSERT INTO `sys_role_permission` VALUES ('9893e63ca62911e991da000c29d316eb', '3', '603', '2019-07-14 19:22:01', '2019-07-14 19:22:01', '1');
INSERT INTO `sys_role_permission` VALUES ('9893e645a62911e991da000c29d316eb', '3', '701', '2019-07-14 19:22:01', '2019-07-14 19:22:01', '1');
INSERT INTO `sys_role_permission` VALUES ('9893e64ca62911e991da000c29d316eb', '3', '702', '2019-07-14 19:22:01', '2019-07-14 19:22:01', '1');
INSERT INTO `sys_role_permission` VALUES ('9893e655a62911e991da000c29d316eb', '3', '704', '2019-07-14 19:22:01', '2019-07-14 19:22:01', '1');
INSERT INTO `sys_role_permission` VALUES ('d5943e16a62c11e991da000c29d316eb', '2', '101', '2019-07-14 19:45:12', '2019-07-14 19:45:12', '1');
INSERT INTO `sys_role_permission` VALUES ('d5943e43a62c11e991da000c29d316eb', '2', '103', '2019-07-14 19:45:12', '2019-07-14 19:45:12', '1');
INSERT INTO `sys_role_permission` VALUES ('d5943e4da62c11e991da000c29d316eb', '2', '102', '2019-07-14 19:45:12', '2019-07-14 19:45:12', '1');
INSERT INTO `sys_role_permission` VALUES ('d5943e54a62c11e991da000c29d316eb', '2', '602', '2019-07-14 19:45:12', '2019-07-14 19:45:12', '1');
INSERT INTO `sys_role_permission` VALUES ('d5943e5ca62c11e991da000c29d316eb', '2', '601', '2019-07-14 19:45:12', '2019-07-14 19:45:12', '1');
INSERT INTO `sys_role_permission` VALUES ('d5943e64a62c11e991da000c29d316eb', '2', '603', '2019-07-14 19:45:12', '2019-07-14 19:45:12', '1');
INSERT INTO `sys_role_permission` VALUES ('d5943e6da62c11e991da000c29d316eb', '2', '701', '2019-07-14 19:45:12', '2019-07-14 19:45:12', '1');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `role_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '角色ID',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `delete_status` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '是否有效  1有效  2无效',
  `phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `last_login_time` timestamp(0) NULL DEFAULT NULL COMMENT '上次登录日期',
  `is_lock` int(1) NULL DEFAULT NULL COMMENT '是否锁定，1未锁定，0锁定',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '运营后台用户表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('10003', 'admin', '928bfd2577490322a6e19b793691467e', '超级用户23', '1', '2017-10-30 11:52:38', '2019-07-14 18:03:16', '1', NULL, NULL, '2019-07-14 19:50:55', 1);
INSERT INTO `sys_user` VALUES ('10004', 'user', '', '莎士比亚+', '2', '2017-10-30 16:13:02', '2019-07-14 19:51:01', '2', NULL, NULL, NULL, 1);
INSERT INTO `sys_user` VALUES ('10005', 'aaa', '123456', 'abba', '1', '2017-11-15 14:02:56', '2019-07-14 20:10:12', '1', NULL, NULL, NULL, 1);
INSERT INTO `sys_user` VALUES ('10007', 'test', '123456', '就看看列表', '3', '2017-11-22 16:29:41', '2019-07-14 18:03:19', '2', NULL, NULL, NULL, 1);
INSERT INTO `sys_user` VALUES ('76f29a387d7a41a3b7f8f450663bd73c', 'tongyao', '7f6421e8feffd91ca398aadf7e4808b7', '拉姆塞', '2', '2019-07-13 19:02:54', '2019-07-14 20:10:15', '1', '17612151270', '1655547993@qq.com', '2019-07-14 19:45:18', 0);

SET FOREIGN_KEY_CHECKS = 1;
