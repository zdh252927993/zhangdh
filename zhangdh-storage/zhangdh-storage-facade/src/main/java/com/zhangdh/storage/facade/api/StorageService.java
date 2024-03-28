package com.zhangdh.storage.facade.api;

/**
 * @author yinshi
 * @date 2024/3/27
 * @apiNote
 */
public interface StorageService {
    /**
     * 扣除存储数量
     */
    void deduct(String commodityCode, int count);
}
