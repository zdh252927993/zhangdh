package com.zhangdh.auth.config;

import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.jwt.StpLogicJwtForSimple;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpLogic;
import cn.dev33.satoken.stp.StpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Configuration
public class SaTokenConfigure implements WebMvcConfigurer {
    /**
     * 注册Sa-token拦截器,打开注解鉴权功能
     *
     * @param registry
     */
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("开始注册Sa-token拦截器............");
        // 注册 Sa-Token 拦截器，打开注解式鉴权功能
        registry.addInterceptor(new SaInterceptor(handle -> {
            //还可以分模块进行校验,不同模块需要不同的鉴权
            SaRouter.match("/user/**", "/user/doLogin", r -> StpUtil.checkRoleOr("user", "admin"));
        })).addPathPatterns("/**").excludePathPatterns(getList());
    }

    /**
     * jwt生成
     * @return
     */
    @Bean
    public StpLogic stpLogicJWT(){
        return new StpLogicJwtForSimple();
    }

    /**
     * 配置所有需要被排除的路径
     *
     * @return
     */
    public List<String> getList() {
        List<String> list = new ArrayList<>();
        list.add("/favicon.ico");
        list.add("/error");
        list.add("/swagger-resources/**");
        list.add("/webjars/**");
        list.add("/v2/**");
        list.add("/doc.html");
        list.add("**/swagger-ui.html");
        return list;
    }



    /**
     * 跨域配置
     *
     * @param registry
     */
    public void addCorsMappings(CorsRegistry registry) {
        log.info("开始进行跨域拦截器配置.......");
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .maxAge(1800)
                .allowedOrigins("*");
    }
}
