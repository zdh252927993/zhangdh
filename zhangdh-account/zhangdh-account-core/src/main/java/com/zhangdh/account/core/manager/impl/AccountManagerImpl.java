package com.zhangdh.account.core.manager.impl;

import com.zhangdh.account.core.entity.AccountEntity;
import com.zhangdh.account.core.mapper.AccountMapper;
import com.zhangdh.account.core.manager.AccountManager;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangdh
 * @since 2024-04-01
 */
@Service
public class AccountManagerImpl extends ServiceImpl<AccountMapper, AccountEntity> implements AccountManager {

}
