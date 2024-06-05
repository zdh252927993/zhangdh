package com.zhangdh.gateway;

import com.zhangdh.common.constant.ServiceNameConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author yinshi
 * @date 2024/4/16
 * @apiNote
 */
@Slf4j
@EnableConfigurationProperties
@SpringBootApplication
public class GatewayApplication {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        ConfigurableApplicationContext context = new SpringApplicationBuilder(GatewayApplication.class)
                .properties("spring.config.name:application", "config/run/application.yml", "config/run/gateway.yml")
                .properties("spring.application.name=" + ServiceNameConstant.GATEWAY)
                .build().run(args);
        int length = context.getBeanDefinitionNames().length;
        log.info("Spring boot启动初始化了 {} 个 Bean。系统CPU:{}, 内存:{} MB, 耗时:{}s", length, Runtime.getRuntime().availableProcessors(), Runtime.getRuntime().maxMemory() / 1024 / 1024, (System.currentTimeMillis() - time) / 1000);
    }
}
