package arch.joboffer;

import arch.company.Company;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@Entity
public class JobOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String requirements;
    private String duties;
    private String location;
    private Double minSalary;
    private Double maxSalary;
    private LocalDateTime dateAdded;
    private Integer submissions;
    @ManyToOne(optional = false)        // nie mozna dodac oferty pracy ktora nie ma przypisanej zadnej firmy (optional = false)
    @JoinColumn(name = "company_id")    // informacja z kluczem obcym bedzie znajdowala sie w tabeli JobOffer
    private Company company;


}
