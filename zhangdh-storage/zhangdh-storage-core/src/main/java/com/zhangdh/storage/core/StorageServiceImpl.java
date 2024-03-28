package com.zhangdh.storage.core;

import com.zhangdh.storage.facade.api.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author yinshi
 * @date 2024/3/27
 * @apiNote
 */
@Slf4j
@DubboService
public class StorageServiceImpl implements StorageService {
    @Override
    public void deduct(String commodityCode, int count) {
        log.info("deduct commodityCode:{}, count:{}", commodityCode, count);
    }
}
