package com.zhangdh.order.core;

import com.zhangdh.order.OrderApplication;
import com.zhangdh.order.core.entity.OrderEntity;
import com.zhangdh.order.core.manager.OrderManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author yinshi
 * @date 2024/3/29
 * @apiNote
 */
@Slf4j
@SpringBootTest(classes = OrderApplication.class)
public class OrderTest {
    @Autowired
    private OrderManager orderManager;

    @Test
    public void orderTest(){
        OrderEntity entity = new OrderEntity();
        entity.setUserId("1");
        entity.setCount(10);
        entity.setMoney(10);
        entity.setCommodityCode("2");
        orderManager.save(entity);
    }
}
