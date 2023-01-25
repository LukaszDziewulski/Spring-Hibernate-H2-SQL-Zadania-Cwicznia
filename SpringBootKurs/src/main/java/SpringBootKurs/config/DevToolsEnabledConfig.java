package SpringBootKurs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Order(2)
@Profile("!prod")
@Configuration
public class DevToolsEnabledConfig {

    private static final String[] DEV_TOOLS_API = {
            "/swagger-ui.html",
            "/swagger-ui/**",
            "/v2/api-docs"
    };

    @Bean
    SecurityFilterChain securityFilterChainDevToolsEnabled(HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .requestMatchers()
                    .antMatchers(DEV_TOOLS_API)
                    .and()
                .sessionManagement(config -> config.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeRequests()
                    .anyRequest().permitAll();
        // @formatter:on

        return http.build();
    }

    @Bean
    WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web
                .ignoring()
                .antMatchers(
                        "/webjars/**",
                        "/swagger-resources/**"
                );
    }

}
