package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger API文档相关配置
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig{
    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.example.demo.controller")//扫描Api包
                .title("demo系统")
                .description("demo相关接口文档")
                .contactName("yl")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }
}
