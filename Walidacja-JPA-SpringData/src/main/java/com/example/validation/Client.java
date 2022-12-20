package com.example.validation;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 2, max = 100)
    private String firstName;
    @NotNull
    @Size(min = 2, max = 100)
    private String lastName;
    @NotNull
    @Email
    @Size(min = 5, max = 100)
    private String email;
    @Min(value = 1)
    private int age;
    @NotNull
    @Pattern(regexp = "[A-Z]{4}[0-9]{3}")
    private String username;

    public Client(String firstName, String lastName, String email, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }
}
