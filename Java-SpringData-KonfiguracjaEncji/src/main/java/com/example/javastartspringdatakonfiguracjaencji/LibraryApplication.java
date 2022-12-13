package com.example.javastartspringdatakonfiguracjaencji;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LibraryApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(LibraryApplication.class, args);
        BookRepository bookRepository = context.getBean(BookRepository.class);
        Book book1 = new Book( "Quo Vadis", "Henryk Sienkiewicz", "Greg", 658, 2022);
        bookRepository.save(book1);

        Book book2 = new Book( "Zemsta", "Fredro", "Greg", 202, 1992);
        bookRepository.save(book2);

    }

}
