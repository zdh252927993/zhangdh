CREATE TABLE `zhangdh_account`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT,
    `user_id`     varchar(255)      DEFAULT NULL,
    `money`       int(11) DEFAULT '0',
    `create_by`   varchar(128)      DEFAULT NULL COMMENT '创建人',
    `update_by`   varchar(128)      DEFAULT NULL COMMENT '更新人',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;