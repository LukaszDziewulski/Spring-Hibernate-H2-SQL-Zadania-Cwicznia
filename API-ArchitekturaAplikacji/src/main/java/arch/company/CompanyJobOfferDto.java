package arch.company;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyJobOfferDto {
    private Long id;
    private String title;
    private String location;
    private Double minSalary;
    private Double maxSalary;
}
