package sec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                request -> request
                        .mvcMatchers("/").permitAll() //  do strony glownej maja dostęp wszyscy
                        .mvcMatchers("/img/**", "/styles/**").permitAll()
                        .mvcMatchers("/secured").hasAnyRole("USER", "ADMIN")
                        .mvcMatchers("/admin/**").hasRole("ADMIN") // Do wszystkich adresów rozpoczynających się od /admin/ mają dostęp tylko użytkownicy z rolą ADMIN
//                        .mvcMatchers("/user-panel/**").hasAuthority("ROLE_USER") // Do wszystkich zasobów, których ścieżka rozpoczyna się od /user-panel/ dostęp mają tylko użytkownicy z rolą USER
//                        .mvcMatchers(HttpMethod.POST, "/calculate").hasAnyRole("USER", "ADMIN") //Żądania POST wysyłane pod adres /calculate mogą wykonywać tylko użytkownicy z rolą USER, lub ADMIN
                        .anyRequest().authenticated() //Wszystkie pozostałe żądania wymagają uwierzytelnienia z dowolną rolą.
        );
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
