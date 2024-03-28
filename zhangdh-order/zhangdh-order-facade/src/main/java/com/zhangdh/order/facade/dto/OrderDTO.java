package com.zhangdh.order.facade.dto;

import lombok.Data;

/**
 * @author yinshi
 * @date 2024/3/27
 * @apiNote
 */
@Data
public class OrderDTO {
    private String userId;
    private String commodityCode;
    private int count;
    private int money;
}
