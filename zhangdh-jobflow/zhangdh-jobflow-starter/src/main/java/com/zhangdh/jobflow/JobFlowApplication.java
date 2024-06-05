package com.zhangdh.jobflow;

import com.zhangdh.common.constant.ServiceNameConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author yinshi
 * @date 2024/5/29
 * @apiNote
 */
@Slf4j
@SpringBootApplication
public class JobFlowApplication {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        ConfigurableApplicationContext context = new SpringApplicationBuilder(JobFlowApplication.class)
                .properties("spring.config.name:application", "config/run/application.yml")
                .properties("spring.application.name=" + ServiceNameConstant.JOBFLOW)
                .build().run(args);
        int length = context.getBeanDefinitionNames().length;
        log.info("Spring boot启动初始化了 {} 个 Bean。系统CPU:{}, 内存:{} MB, 耗时:{}s", length, Runtime.getRuntime().availableProcessors(), Runtime.getRuntime().maxMemory() / 1024 / 1024, (System.currentTimeMillis() - time) / 1000);

    }
}
