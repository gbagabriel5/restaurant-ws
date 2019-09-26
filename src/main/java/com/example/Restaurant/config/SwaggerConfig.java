package com.example.Restaurant.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Configuração do Swagger para consultar a API através de um browser e para gerar API para o FRONT
 */
@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig implements WebMvcConfigurer {

    private static  final String TITLE="RESTAURANT API";
//    private static  final String DESCRIPTION="<h1>( ͡° ͜ʖ ͡°)( ͠° ͟ʖ ͡°)( ͡~ ͜ʖ ͡°)( ͡ʘ ͜ʖ ͡ʘ)( ͡o ͜ʖ ͡o)(° ͜ʖ °)( ‾ʖ̫‾)( ಠ ͜ʖಠ)( ͡° ʖ̯ ͡°)( ͡ಥ ͜ʖ ͡ಥ)༼ ͡° ͜ʖ ͡° ༽(·̿Ĺ̯·̿ ̿)</h1>";
//    private static  final String VERSION="3.0.0";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.Restaurant.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE", "PATCH");
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfos = new ApiInfoBuilder()
                .title(TITLE)
//                .description(DESCRIPTION)
                .build();
        return apiInfos;
    }
}