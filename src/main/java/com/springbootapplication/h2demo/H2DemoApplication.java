package com.springbootapplication.h2demo;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class H2DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(H2DemoApplication.class, args);
    }

    @Bean
    public Docket swaggerConfiguration() {
        // Return a prepared Docket instance(not docker)
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("com.springbootapplication.h2demo"))
                .build().apiInfo(apiDettails());
    }

    private ApiInfo apiDettails() {
        return new ApiInfo(
                "Inventory  API",
                "Welcome",
                "1.0",
                "",
                new springfox.documentation.service.Contact("yuval zolo", "https://github.com/yuvalzolo" , "yuvalik94@gmail.com"),
                "API License",
                "https://github.com/yuvalzolo",
                Collections.emptyList()
        );
    }

}
