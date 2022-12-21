package sec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class CustomInMemoryUserDetailsManager extends InMemoryUserDetailsManager {
    public CustomInMemoryUserDetailsManager() {
        User.UserBuilder userBuilder = User.builder();
        UserDetails admin = userBuilder.username("admin").password("{noop}admin1").roles("ADMIN").build();  //noop to hashowanie hasła
        UserDetails user1 = userBuilder.username("jan").password("{noop}jan123").roles("USER").build();  //noop to hashowanie hasła
        createUser(admin);
        createUser(user1);
    }
}
