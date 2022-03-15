package com.example.parkeerapp.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SpringFoxConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.parkeerapp.web"))
                .paths(PathSelectors.any())
                .build().apiInfo(metaInfo());
    }
    private ApiInfo metaInfo() {
        List<VendorExtension> vendorExtensions = new ArrayList<>();
        return new ApiInfo("ParkeerAPI",
                "API voor parkeergarage",
                "0.8",
                "",
                new Contact("Nathan Van de Wildebergh", "", "nathan.vandewildebergh@gmail.com"),
                "Apache 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0", vendorExtensions);
    }
}
