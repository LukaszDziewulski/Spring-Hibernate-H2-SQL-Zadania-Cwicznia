package com.example.apiarchitekturaaplikacji;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String city;
    private Integer employees;
    private String telephone;
    private String email;
    @OneToMany(mappedBy = "company")  // relacja zwrotna i wskazujemy nazwe pola company
    private List<JobOffer> jobOffers = new ArrayList<>();
}
