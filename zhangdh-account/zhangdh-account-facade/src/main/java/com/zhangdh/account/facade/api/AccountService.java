package com.zhangdh.account.facade.api;

/**
 * @author yinshi
 * @date 2024/3/27
 * @apiNote
 */
public interface AccountService {
    /**
     * 从用户账户中借出
     */
    void debit(String userId, int money);
}
