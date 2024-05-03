package com.nogueira.springexpert.config.swagger;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityScheme.Type;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

   private final String SECURITY_SCHEMA_NAME = "Bearer Token";

   @Bean
   public OpenAPI openAPI() {
      return new OpenAPI()
              .info(info())
              .components(components())
              .addSecurityItem(
                      new SecurityRequirement().addList("Bearer Token")
              );
   }

   private Components components() {
      return new Components()
              .addSecuritySchemes(
                      "Bearer Token",
                      new SecurityScheme()
                              .name("Bearer Token")
                              .type(Type.HTTP)
                              .scheme("bearer")
                              .description("Token de autenticação obrigatório para realizar as requisições da API")
                              .bearerFormat("JWT")
              );
   }

   private Info info() {
      return new Info()
              .title("Spring-Expert")
              .description("Api que simula um sistema de cadastro de pedidos, contendo clientes e produtos.")
              .version("1.0.0");
   }
}
