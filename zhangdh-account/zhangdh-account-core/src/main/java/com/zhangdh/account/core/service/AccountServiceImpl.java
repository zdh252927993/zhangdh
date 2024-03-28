package com.zhangdh.account.core.service;

import com.zhangdh.account.facade.api.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author yinshi
 * @date 2024/3/27
 * @apiNote
 */
@Slf4j
@DubboService
public class AccountServiceImpl implements AccountService {
    @Override
    public void debit(String userId, int money) {
        log.info("debit userId:{}, money:{}", userId, money);
    }
}
