package com.practicacrud.demo.infraestructure.documentation;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.awt.*;

//Agregar Postman a aplication.yml
@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI customOpenApi(@Value("${appDescription}")String appDescription,
                                 @Value("${appVersion}")String appVersion){
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                .title("Hexagonal User Crud")
                .version(appVersion)
                .description(appDescription)
                .termsOfService("https://swagger.io/terms/")
                .license(new License().name("Apache 2.0").url("http://springdoc.org")));



    }
}
