package sec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
        http.formLogin(form -> form.loginPage("/login").permitAll());
        http.csrf().disable();  // wyłączenie filtra
        return http.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        User.UserBuilder userBuilder = User.builder();
//        UserDetails admin = userBuilder.username("admin").password("{noop}admin1").roles("ADMIN").build();  //noop to hashowanie hasła
//        UserDetails user1 = userBuilder.username("jan").password("{noop}jan123").roles("USER").build();  //noop to hashowanie hasła
//        return new InMemoryUserDetailsManager(admin, user1);
//    }
}
