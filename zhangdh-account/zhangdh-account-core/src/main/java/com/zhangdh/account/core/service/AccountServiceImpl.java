package com.zhangdh.account.core.service;

import com.zhangdh.account.core.entity.AccountEntity;
import com.zhangdh.account.core.manager.AccountManager;
import com.zhangdh.account.facade.api.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * @author yinshi
 * @date 2024/3/27
 * @apiNote
 */
@Slf4j
@DubboService
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountManager accountManager;

    @Override
    public void debit(String userId, int money) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setUserId(userId);
        accountEntity.setMoney(money);
        accountManager.save(accountEntity);
    }
}
