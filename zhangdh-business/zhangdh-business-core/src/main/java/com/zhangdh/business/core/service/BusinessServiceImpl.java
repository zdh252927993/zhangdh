package com.zhangdh.business.core.service;

import com.zhangdh.business.facade.api.BusinessService;
import com.zhangdh.order.facade.api.OrderService;
import com.zhangdh.storage.facade.api.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * @author yinshi
 * @date 2024/3/27
 * @apiNote
 */
@Service
public class BusinessServiceImpl implements BusinessService {
    @DubboReference(timeout = 30*1000)
    private StorageService storageService;

    @DubboReference
    private OrderService orderService;

    @GlobalTransactional
    @Override
    public void purchase(String userId, String commodityCode, int orderCount) {

        orderService.create(userId, commodityCode, orderCount);
        storageService.deduct(commodityCode, orderCount);

    }
}
