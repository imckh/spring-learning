# [Uploading Files](http://spring.io/guides/gs/uploading-files/)
This guide walks you through the process of creating a server application that can receive HTTP multi-part file uploads.

## What you’ll build
You will create a Spring Boot web application that accepts file uploads. You will also build a simple HTML interface to upload a test file.

## 涉及

### before

首先需要一个容器开始, 所以`spring-boot-starter-thymeleaf`和`spring-boot-starter-web`已经加入了依赖中

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```

为了使用servlet容器上传文件, 需要注册一个`MultipartConfigElement`类(`web.xml`中是`<multipart-config>`),
但是spring-boot自动配置好了