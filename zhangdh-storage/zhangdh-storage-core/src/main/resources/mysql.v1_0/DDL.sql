CREATE TABLE `zhangdh_storage`
(
    `id`             int(11) NOT NULL AUTO_INCREMENT,
    `commodity_code` varchar(255) DEFAULT NULL,
    `count`          int(11) DEFAULT '0',
    `create_by`     varchar(128) DEFAULT NULL COMMENT '创建人',
    `update_by`     varchar(128) DEFAULT NULL COMMENT '更新人',
    `create_time`   datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`   datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
    UNIQUE KEY `commodity_code` (`commodity_code`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;