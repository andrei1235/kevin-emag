package ro.problem.kevin.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("ro.problem.kevin.controller"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "API ",
                "API Documentation",
                "API 1.0",
                "", null, "", "", Collections.emptyList());
    }
}
