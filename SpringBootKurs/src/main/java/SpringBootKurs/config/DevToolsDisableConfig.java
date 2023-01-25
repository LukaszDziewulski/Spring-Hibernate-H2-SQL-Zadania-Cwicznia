package SpringBootKurs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Order(2)
@Profile("prod")
@Configuration
public class DevToolsDisableConfig {

    private static final String[] DEV_TOOLS_API = {
            "/swagger-ui.html",
            "/swagger-ui/**",
            "/v2/api-docs"
    };

    @Bean
    SecurityFilterChain securityFilterChainDevToolsDisabled(HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .requestMatchers()
                    .antMatchers(DEV_TOOLS_API)
                    .and()
                .authorizeRequests()
                    .anyRequest().denyAll();
        // @formatter:on

        return http.build();
    }

}
