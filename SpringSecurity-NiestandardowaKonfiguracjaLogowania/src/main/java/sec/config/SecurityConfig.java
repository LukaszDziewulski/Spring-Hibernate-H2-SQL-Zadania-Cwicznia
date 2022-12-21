package sec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
        http.formLogin(form -> form
                .loginPage("/logowanie")
                .loginProcessingUrl("/zaloguj")
                .usernameParameter("user")
                .passwordParameter("pass")
                .permitAll());
        http.csrf().disable();  // wyłączenie filtra
        return http.build();
    }
}
