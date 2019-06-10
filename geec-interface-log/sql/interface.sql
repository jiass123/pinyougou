/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : study

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 21/05/2019 15:42:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_interface_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_interface_log`;
CREATE TABLE `sys_interface_log` (
  `log_id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '主键',
  `interface_no` varchar(50) NOT NULL COMMENT '接口编号',
  `request_time` datetime DEFAULT NULL COMMENT '请求发送时间',
  `request_header` text COMMENT '请求头内容',
  `request_param` text COMMENT '请求参数内容',
  `response_time` datetime DEFAULT NULL COMMENT '响应接收时间',
  `response_status` int(3) DEFAULT NULL COMMENT '响应状态码',
  `response_data` text COMMENT '响应内容',
  `is_caller` tinyint(1) DEFAULT NULL COMMENT '是否调用 0 被调用 1 调用',
  PRIMARY KEY (`log_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='接口日志表';

-- ----------------------------
-- Table structure for sys_interfaces
-- ----------------------------
DROP TABLE IF EXISTS `sys_interfaces`;
CREATE TABLE `sys_interfaces` (
  `interface_id` int(11) NOT NULL AUTO_INCREMENT,
  `interface_method` varchar(10) DEFAULT NULL COMMENT '接口调用方法',
  `interface_no` varchar(100) DEFAULT NULL COMMENT '接口编码',
  `interface_url` varchar(255) DEFAULT NULL COMMENT '接口地址',
  `interface_desc` varchar(255) DEFAULT NULL COMMENT '接口说明',
  PRIMARY KEY (`interface_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='接口定义表';

SET FOREIGN_KEY_CHECKS = 1;
