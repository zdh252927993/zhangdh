package com.zhangdh.order.facade.api;

/**
 * @author yinshi
 * @date 2024/3/27
 * @apiNote
 */

public interface OrderService {
    /**
     * 创建订单
     */
    void create(String userId, String commodityCode, int orderCount);
}
