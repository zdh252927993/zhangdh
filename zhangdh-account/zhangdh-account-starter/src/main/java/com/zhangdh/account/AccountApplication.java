package com.zhangdh.account;

import com.zhangdh.common.constant.ServiceNameConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author yinshi
 * @date 2024/3/27
 * @apiNote
 */
@Slf4j
@SpringBootApplication
public class AccountApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(AccountApplication.class)
                .properties("spring.config.name:bootstrap", "config/run/application.yml")
                .properties("spring.application.name=" + ServiceNameConstant.ACCOUNT)
                .build().run(args);
        int length = context.getBeanDefinitionNames().length;
        log.info("Spring boot启动初始化了 {} 个 Bean。系统CPU:{}, 内存:{} MB", length, Runtime.getRuntime().availableProcessors(), Runtime.getRuntime().maxMemory() / 1024 / 1024);

    }
}
