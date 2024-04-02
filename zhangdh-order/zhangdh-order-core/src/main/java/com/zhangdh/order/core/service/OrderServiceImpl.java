package com.zhangdh.order.core.service;

import com.zhangdh.account.facade.api.AccountService;
import com.zhangdh.order.core.entity.OrderEntity;
import com.zhangdh.order.core.manager.OrderManager;
import com.zhangdh.order.facade.api.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * @author yinshi
 * @date 2024/3/27
 * @apiNote
 */
@Slf4j
@DubboService
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderManager orderManager;

    @DubboReference
    private AccountService accountService;

    @Override
    public void create(String userId, String commodityCode, int orderCount) {
        int orderMoney = calculate(commodityCode, orderCount);

        accountService.debit(userId, orderMoney);

        OrderEntity order = new OrderEntity();
        order.setUserId(userId);
        order.setCommodityCode(commodityCode);
        order.setCount(orderCount);
        order.setMoney(orderMoney);

        // INSERT INTO orders ...
        orderManager.save(order);
//        return null;
    }

    private int calculate(String commodityCode, int orderCount) {
        return orderCount * 10;
    }
}
