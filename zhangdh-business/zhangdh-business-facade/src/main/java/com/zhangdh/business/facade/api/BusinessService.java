package com.zhangdh.business.facade.api;

/**
 * @author yinshi
 * @date 2024/3/27
 * @apiNote
 */
public interface BusinessService {
    void purchase(String userId, String commodityCode, int orderCount);
}
