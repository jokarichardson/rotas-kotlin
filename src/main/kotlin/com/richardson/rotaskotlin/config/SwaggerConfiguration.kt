package com.richardson.rotaskotlin.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger.web.DocExpansion
import springfox.documentation.swagger.web.UiConfiguration
import springfox.documentation.swagger.web.UiConfigurationBuilder
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SwaggerConfiguration {
    companion object {
        const val basePackage = "com.richardson.rotaskotlin"
        const val title = "Rotas Kotlin"
        const val description = "Buscador da rota mais barata entre uma origem e um destino"
        const val version = "1.0.0-SNAPSHOT"
        const val license = "Copyright © Richardson Software Ltda - 2020"
    }

    @Bean
    fun api(): Docket = Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage(basePackage))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(this.metadata())

    fun metadata(): ApiInfo = ApiInfoBuilder()
            .title(title)
            .description(description)
            .version(version)
            .license(license)
            .build()

    @Bean
    fun uiConfig(): UiConfiguration = UiConfigurationBuilder.builder()
            .docExpansion(DocExpansion.LIST)
            .build()
}