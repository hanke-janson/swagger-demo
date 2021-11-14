package com.hj.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2//开启Swagger2
public class SwaggerConfig {
    @Bean
    public Docket docket1() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }

    @Bean
    public Docket docket2() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }

    @Bean
    public Docket docket3() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
    }

    @Bean
    public Docket docket4() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("D");
    }

    //配置了Swagger的Bean实例
    @Bean
    public Docket docket(Environment env) {

        //设置显示Swagger的环境
        Profiles profiles = Profiles.of("dev", "test");
        //判断是否处于设定的环境
        boolean flag = env.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //配置API文档分组
                .groupName("hanke")
                //enable()是否启动Swagger
                .enable(flag)
                .select()
                //RequestHandlerSelectors,配置要扫描接口的方式
                //basePackage指定扫描的包
                //any()扫描全部
                //none()不扫描
                //withClassAnnotation扫描类上的注解，参数是一个注解的反射对象
                //withMethodAnnotation扫描方法上的注解
                .apis(RequestHandlerSelectors.basePackage("com.hj.swagger.controller"))
                //过滤路径
                //.paths(PathSelectors.ant("/hj/**"))
                .build();//build 工厂模式
    }

    //配置Swagger信息ApiInfo
    public ApiInfo apiInfo() {
        //作者信息
        Contact contact = new Contact("hanke-janson", "https://github.com/hanke-janson", "hankejanson@gmail");

        return new ApiInfo(
                "Swagger API文档",
                "Swagger RestFul APIs",
                "v1.0",
                "https://github.com/hanke-janson",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
