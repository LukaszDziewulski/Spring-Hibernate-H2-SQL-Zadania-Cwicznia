package SpringBootKurs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;

@EnableSwagger2
@Configuration
public class ConfigSwagger {

    private static final String API_TITLE = "eFarm API";
    private static final String VERSION = "v0.0.1";
    private static final String AUTHORIZATION_SCOPE_NAME = "global";
    private static final String API_KEY_JWT = "JWT";
    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String API_KEY_PASS_AS = "header";

    @Bean
    Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("EFarm api")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(List.of(apiKey()))
                .securityContexts(Collections.singletonList(securityContext()));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(API_TITLE)
                .version(VERSION)
                .build();
    }

    private ApiKey apiKey() {
        return new ApiKey(API_KEY_JWT, AUTHORIZATION_HEADER, API_KEY_PASS_AS);
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .build();
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = new AuthorizationScope(AUTHORIZATION_SCOPE_NAME, "Global scope");
        return List.of(new SecurityReference(API_KEY_JWT, authorizationScopes));
    }
}
