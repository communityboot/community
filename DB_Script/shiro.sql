
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;


DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission`  (
  `id` varchar(64) NOT NULL ,
  `permission_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remarks` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);


INSERT INTO `t_permission` VALUES (1, 'select', '查询');
INSERT INTO `t_permission` VALUES (2, 'insert', '增加');
INSERT INTO `t_permission` VALUES (3, 'update', '更新');
INSERT INTO `t_permission` VALUES (4, 'delete', '删除');


DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `id` varchar(64) NOT NULL ,
  `remarks` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (1, '普通角色', 'p');
INSERT INTO `t_role` VALUES (2, '重要角色', 'ip');
INSERT INTO `t_role` VALUES (3, '超级角色', 'vip');

-- ----------------------------
-- Table structure for t_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission`  (
  `id` varchar(64) NOT NULL ,
  `remarks` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `permission_id` int(11) NULL DEFAULT NULL,
  `role_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- ----------------------------
-- Records of t_role_permission
-- ----------------------------
INSERT INTO `t_role_permission` VALUES (1, '授予普通角色select权限', 1, 1);
INSERT INTO `t_role_permission` VALUES (2, '授予重要角色select权限', 1, 2);
INSERT INTO `t_role_permission` VALUES (3, '授予重要角色insert权限', 2, 2);
INSERT INTO `t_role_permission` VALUES (4, '授予超级角色select权限', 1, 3);
INSERT INTO `t_role_permission` VALUES (5, '授予超级角色insert权限', 2, 3);
INSERT INTO `t_role_permission` VALUES (6, '授予超级角色update权限', 3, 3);
INSERT INTO `t_role_permission` VALUES (7, '授予超级角色delete权限', 4, 3);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` varchar(64) NOT NULL ,
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `remarks` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`)
);

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, '123', '陈汇奇', 'admin');

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role`  (
  `id` varchar(64) NOT NULL ,
  `remarks` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role_id` int(11) NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES (1, '授权chq', 3, 4);

SET FOREIGN_KEY_CHECKS = 1;
