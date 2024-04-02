package com.zhangdh.business.core.controller;

import com.zhangdh.business.facade.api.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yinshi
 * @date 2024/3/28
 * @apiNote
 */
@RestController
public class BusinessController {
    @Autowired
    private BusinessService businessService;

    @GetMapping("/purchase")
    public void purchase() {
        String userId = "1";
        String commodityCode = "2";
        int orderCount = 1;
        businessService.purchase(userId, commodityCode, orderCount);
    }
}
