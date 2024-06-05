package com.zhangdh.business.controller;

import com.zhangdh.business.facade.api.BusinessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;


/**
 * @author yinshi
 * @date 2024/3/28
 * @apiNote
 */

@Slf4j
@RestController
@RequestMapping("business")
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

    @GetMapping("/ok")
    public String ok(HttpServletRequest request){
        Enumeration<String> headerNames = request.getHeaderNames();
//        log.info(JSON.toJSONString(headerNames));
        return "ok";
    }
}
