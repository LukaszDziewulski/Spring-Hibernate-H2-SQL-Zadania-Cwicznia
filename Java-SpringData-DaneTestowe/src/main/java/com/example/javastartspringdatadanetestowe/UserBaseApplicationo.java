package com.example.javastartspringdatadanetestowe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class UserBaseApplicationo {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(UserBaseApplicationo.class, args);
        UserRepository userRepository = context.getBean(UserRepository.class);
        userRepository.findAll().forEach(System.out::println);

    }

}
