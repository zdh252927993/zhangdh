package com.zhangdh.gateway.pojo;

import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * @author yinshi
 * @date 2024/6/5
 * @apiNote
 */
@Component
@ConfigurationProperties
@Validated
@Primary
@NacosConfigurationProperties(dataId = "route.yml")
public class IGatewayProperties extends GatewayProperties {
}
