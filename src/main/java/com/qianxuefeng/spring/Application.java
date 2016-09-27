package com.qianxuefeng.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;  
  
@Configuration
@EnableSwagger2
@SpringBootApplication  
public class Application {  
  
    public static void main(String[] args) {  
        SpringApplication.run(Application.class, args);  
    }  
    
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("api")
                .genericModelSubstitutes(DeferredResult.class)
//                  .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
                .pathMapping("/")//拼接根目录
                .select()
                .paths(PathSelectors.regex("/api.*"))//过滤的接口，显示/api/开头的
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("Shawn", "http://www.qianxuefeng.com", "849276016@qq.com");
        ApiInfo apiInfo = new ApiInfo("SpringBootSamples API接口",//大标题
                "本页面为SpringBootSamples开放接口文档，接口风格为REST",//小标题
                "0.1",//版本
                "urn:tos",
                contact,//作者
                "Apache 2.0",//链接显示文字
                "http://www.apache.org/licenses/LICENSE-2.0"//网站链接
        );
        return apiInfo;
    }
}  