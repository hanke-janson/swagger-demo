package com.hj.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2//开启Swagger2
public class SwaggerConfig {
    //配置了Swagger的Bean实例
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis()
                .build();//build 工厂模式
    }
    //配置Swagger信息ApiInfo
    public ApiInfo apiInfo() {
        //作者信息
        Contact contact = new Contact("hanke-janson", "https://github.com/hanke-janson", "hankejanson@gmail");

        return new ApiInfo(
                "Swagger API文档",
                "Swagger API测试日志",
                "v1.0",
                "https://github.com/hanke-janson",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
