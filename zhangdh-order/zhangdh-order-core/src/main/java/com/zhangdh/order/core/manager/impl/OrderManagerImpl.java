package com.zhangdh.order.core.manager.impl;

import com.zhangdh.order.core.entity.OrderEntity;
import com.zhangdh.order.core.mapper.OrderMapper;
import com.zhangdh.order.core.manager.OrderManager;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单 服务实现类
 * </p>
 *
 * @author zhangdh
 * @since 2024-03-27
 */
@Service
public class OrderManagerImpl extends ServiceImpl<OrderMapper, OrderEntity> implements OrderManager {

}
