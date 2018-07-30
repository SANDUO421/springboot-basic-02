/*
Navicat Oracle Data Transfer
Oracle Client Version : 10.2.0.5.0

Source Server         : springboot
Source Server Version : 110200
Source Host           : 192.168.35.33:1521
Source Schema         : SPRINGBOOT

Target Server Type    : ORACLE
Target Server Version : 110200
File Encoding         : 65001

Date: 2018-07-26 11:17:12
*/


-- ----------------------------
-- Table structure for PERSON
-- ----------------------------
DROP TABLE "SPRINGBOOT"."PERSON";
CREATE TABLE "SPRINGBOOT"."PERSON" (
"ID" NUMBER(19) NOT NULL ,
"ADDRESS" VARCHAR2(255 CHAR) NULL ,
"AGE" NUMBER(10) NULL ,
"NAME" VARCHAR2(255 CHAR) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of PERSON
-- ----------------------------
INSERT INTO "SPRINGBOOT"."PERSON" VALUES ('8', null, null, null);
INSERT INTO "SPRINGBOOT"."PERSON" VALUES ('9', '上海', '26', 'sanduo');
INSERT INTO "SPRINGBOOT"."PERSON" VALUES ('1', '深圳', '32', '王非');
INSERT INTO "SPRINGBOOT"."PERSON" VALUES ('2', '西安', '31', '李云');
INSERT INTO "SPRINGBOOT"."PERSON" VALUES ('3', '深圳', '26', '孟江');
INSERT INTO "SPRINGBOOT"."PERSON" VALUES ('4', '深圳', '34', '孙云天');
INSERT INTO "SPRINGBOOT"."PERSON" VALUES ('5', '深圳', '19', '孔燕');
INSERT INTO "SPRINGBOOT"."PERSON" VALUES ('6', '深圳', '14', '张胜利');
INSERT INTO "SPRINGBOOT"."PERSON" VALUES ('7', '深圳', '40', '王鹏飞');

-- ----------------------------
-- Indexes structure for table PERSON
-- ----------------------------

-- ----------------------------
-- Checks structure for table PERSON
-- ----------------------------
ALTER TABLE "SPRINGBOOT"."PERSON" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table PERSON
-- ----------------------------
ALTER TABLE "SPRINGBOOT"."PERSON" ADD PRIMARY KEY ("ID");
