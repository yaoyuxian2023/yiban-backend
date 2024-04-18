package com.yaoyx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author: Augue
 * @date: 2024/04/15
 * @ClassName: yiban-backend
 * @Description: 自定义 Swagger 接口文档的配置
 */
@Configuration // 配置类
@EnableSwagger2 // 开启 swagger2 的自动配置
@Profile({"dev","test"})  // 版本控制访问
public class SwaggerConfig {
    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 标注控制器的位置
                .apis(RequestHandlerSelectors.basePackage("com.yaoyx.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    // 基本信息设置
    private ApiInfo apiInfo() {
        Contact contact = new Contact(
                "Augue", // 作者姓名
                "yaoyx.cn", // 作者网址
                "yaoyx718@163.com"); // 作者邮箱
        return new ApiInfoBuilder()
                .title("易伴伙伴匹配系统-接口文档") // 标题
                .description("易伴用户中心接口文档") // 描述
                .termsOfServiceUrl("https://github.com/yaoyuxian2023") // 跳转连接
                .version("1.0") // 版本
                .license("Swagger-的使用(详细教程)")
                .licenseUrl("https://blog.csdn.net/xhmico/article/details/125353535")
                .contact(contact)
                .build();
    }

}

