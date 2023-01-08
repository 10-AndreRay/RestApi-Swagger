package com.dev.restapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private Contact contato() {
        return new Contact("André",
                "andreray053@gmail.com",
                "https://www.github.com/10-AndreRay");
    }

    private ApiInfoBuilder informacoesAPI() {
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

        apiInfoBuilder.title("Rest API - Users");
        apiInfoBuilder.description("API de exemplo para implementar documentação com o Swagger");
        apiInfoBuilder.version("1.0");
        apiInfoBuilder.termsOfServiceUrl("Termos de uso: Open Source");
        apiInfoBuilder.license("MIT");
        apiInfoBuilder.licenseUrl("https://opensource.org/licenses/MIT");
        apiInfoBuilder.contact(this.contato());

        return apiInfoBuilder;
    }

    @Bean
    public Docket detalhesAPI() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        docket
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dev.restapi.controllers"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.informacoesAPI().build())
                .consumes(new HashSet<String>(Arrays.asList("application/json")))
                .produces(new HashSet<String>(Arrays.asList("application/json")));

        return docket;
    }
}
