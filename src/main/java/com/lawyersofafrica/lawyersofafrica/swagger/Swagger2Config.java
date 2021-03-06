package com.lawyersofafrica.lawyersofafrica.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class Swagger2Config extends WebMvcConfigurationSupport {
    @Bean
    public Docket QCiApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.lawyersofafrica"))
                .paths(PathSelectors.any())//PathSelectors.ant("/api/*")
                .build()
                .apiInfo(apiInfo());
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("lawyers of africa")
                .description("lawyers of africa")
                .termsOfServiceUrl("https://www.lawyersofafrica.com")
                .contact(new Contact("RURAARA TECH LIMITED","https://www.ruraaratech.com",
                        "info@lawyersofafrica.com"))
                .license("A license given")
                .licenseUrl("https://www.lawyersofafrica.com")
                .version("1.0")
                .build();
    }

}
