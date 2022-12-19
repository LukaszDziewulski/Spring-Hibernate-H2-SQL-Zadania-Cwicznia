package com.example.walidacjawprowadzeniekonfiguracja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class WalidacjaApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(WalidacjaApplication.class, args);
        PersonService personService = context.getBean(PersonService.class);

        Person person1 = new Person("ada", null, "jankowlski@lasorg", 25);
        personService.addPerson(person1);
        System.out.println(personService.toString());
    }

}
