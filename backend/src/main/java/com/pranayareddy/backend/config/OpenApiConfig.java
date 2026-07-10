package com.pranayareddy.backend.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI logisticsOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("Logistics Management Platform API")
                        .description("REST APIs for Logistics Management Platform")
                        .version("v1.0.0")
                        .contact(new Contact()
                                .name("Pranaya Reddy")
                                .email("pranaya571@gmail.com"))
                        .license(new License()
                                .name("MIT")))
                .externalDocs(new ExternalDocumentation()
                        .description("GitHub Repository"));
    }
}