package SpringBootKurs.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.builders.PathSelectors;

@EnableSwagger2
@Configuration
public class Config {

    @Bean
    public Docket swaggerApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.regex ("^(?!/(error).*$).*$"))  // wyłącznie errorów na swaggerze
                .build();
    }
}
