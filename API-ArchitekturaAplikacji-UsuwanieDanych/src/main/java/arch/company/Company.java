package arch.company;

import arch.joboffer.JobOffer;
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
    @OneToMany(mappedBy = "company",cascade = CascadeType.REMOVE)  // relacja zwrotna i wskazujemy nazwe pola company --- Casade type remowe - dzieki temu usuwajac firme usuwaja sie jej oferty
    private List<JobOffer> jobOffers = new ArrayList<>();
}
