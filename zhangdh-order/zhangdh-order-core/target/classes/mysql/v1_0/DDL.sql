Create Database If Not Exists `order` CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

create table if Not Exists `order`
(
    `id`            bigint(20)   NOT NULL AUTO_INCREMENT COMMENT '主键',
    `userId`        varchar(255)          DEFAULT NULL COMMENT '用户id',
    `commodityCode` varchar(255)          DEFAULT NULL COMMENT '产品code',
    `count`         int(10)               DEFAULT NULL COMMENT '数量',
    `money`         int(10)               DEFAULT NULL COMMENT '金额',
    `create_by`     varchar(128) NOT NULL COMMENT '创建人',
    `update_by`     varchar(128) NOT NULL COMMENT '更新人',
    `create_time`   datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`   datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARSET = utf8mb4 COMMENT ='订单';