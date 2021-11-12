# Swagger

学习目标：

- 了解Swagger的作用和概念
- 了解前后端分离
- 在SpringBoot中集成

## Swagger简介

**前后端分离**

Vue + SpringBoot

后端时代：前端只用管理静态页面；html==>后端。模板引擎JSP=>后端是主力

前后端分离时代：

- 后端：后端控制层，服务层，数据访问层【后端团队】
- 前端：前端控制层，视图层【前端团队】
    - 伪造后端数据，json。已经存在了，不需要后端，前端工程依旧能跑起来
- 前后端如何交互？===> API
- 前后端相对独立，松耦合；
- 前后端甚至可以部署在不同的服务器上；

产生一个问题：

- 前后端集成联调，前端人员和后端人员无法做到“及时协商，尽早解决”，最终导致问题集中爆发；

解决方案：

- 首先制定一个schema[计划的提纲]，实时更新最新的API，降低集成风险；
- 早些年制定word计划文档；
- 前后端分离：
    - 前端测试后端接口：postman
    - 后端提供接口，需要实时更新最新的消息及改动

### Swagger

- 号称世界上最流行的API框架；
- RestFul API 文档在线自动生成工具=>==API文档与API定义同步更新==
- 直接运行，可以在线测试API接口；
- 支持多种语言（Java,PHP...）;

官网：https://swagger.io/

在项目中使用Swagger需要springfox;

- Swagger
- ui

## SpringBoot集成Swagger

1、新建一个Spring Boot项目 = web项目

2、导入相关依赖

```xml

<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>2.9.2</version>
</dependency>

<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>2.9.2</version>
</dependency>

```

3、编写一个Hello工程

4、配置Swagger ==> Configure

```java

@Configuration
@EnableSwagger2//开启Swagger2
public class SwaggerConfig {
}
```

5、测试运行
http://localhost:8080/swagger-ui.html

## 配置Swagger

Swagger的Bean实例Docket；

## Swagger配置扫描接口

Docket.select()