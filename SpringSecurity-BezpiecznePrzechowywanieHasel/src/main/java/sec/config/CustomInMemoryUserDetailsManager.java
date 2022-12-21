package sec.config;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;

@Service
public class CustomInMemoryUserDetailsManager extends InMemoryUserDetailsManager {
    public CustomInMemoryUserDetailsManager() {
        User.UserBuilder userBuilder = User.builder();

        String password1 = "{bcrypt}" + new BCryptPasswordEncoder().encode("hard");
        System.out.println(password1);
        UserDetails admin = userBuilder.username("admin").password(password1).roles("ADMIN").build();  //noop to hashowanie hasła

        String password2 = "{MD5}" + new MessageDigestPasswordEncoder("MD5").encode("dog8");
        System.out.println(password2);
        UserDetails user1 = userBuilder.username("jan").password(password2).roles("USER").build();  //noop to hashowanie hasła

        String password3 = "{argon2}" + new Argon2PasswordEncoder(16,32,1,16384,2).encode("javaiscool");
        System.out.println(password3);
        UserDetails user2 = userBuilder.username("java_lover").password(password3).roles("USER").build();
        createUser(admin);
        createUser(user1);
        createUser(user2);
    }
}
