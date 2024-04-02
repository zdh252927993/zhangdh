package com.zhangdh.storage.core;

import com.zhangdh.storage.core.entity.StorageEntity;
import com.zhangdh.storage.core.manager.StorageManager;
import com.zhangdh.storage.facade.api.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @author yinshi
 * @date 2024/3/27
 * @apiNote
 */
@Slf4j
@DubboService
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageManager storageManager;
    @Override
    public void deduct(String commodityCode, int count) {
//        if(new Random().nextBoolean()) {
            StorageEntity storageEntity = new StorageEntity();
            storageEntity.setId(1);
            storageEntity.setCommodityCode(commodityCode);
            storageEntity.setCount(new Random().nextInt());
            storageManager.saveOrUpdate(storageEntity);
//        } else {
//            throw new RuntimeException("test");
//        }
    }
}
