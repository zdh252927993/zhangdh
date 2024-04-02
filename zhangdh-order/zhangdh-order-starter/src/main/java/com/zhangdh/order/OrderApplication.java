package com.zhangdh.order;

import com.zhangdh.common.constant.ServiceNameConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
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
@MapperScan("com.zhangdh.order.core.mapper")
@EnableDubbo
public class OrderApplication {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        ConfigurableApplicationContext context = new SpringApplicationBuilder(OrderApplication.class)
                .properties("spring.config.name:application", "config/run/application.yml")
                .properties("spring.application.name=" + ServiceNameConstant.ORDER)
                .build().run(args);
        int length = context.getBeanDefinitionNames().length;
        log.info("Spring boot启动初始化了 {} 个 Bean。系统CPU:{}, 内存:{} MB, 耗时:{}s", length, Runtime.getRuntime().availableProcessors(), Runtime.getRuntime().maxMemory() / 1024 / 1024, (System.currentTimeMillis() - time) / 1000);

    }


}
