package com.example.apiarchitekturaaplikacji;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class CompanyDto {
    private Long id;
    private String name;
    private String description;
    private String city;
    private Integer employees;
    private String telephone;
    private String email;
}
