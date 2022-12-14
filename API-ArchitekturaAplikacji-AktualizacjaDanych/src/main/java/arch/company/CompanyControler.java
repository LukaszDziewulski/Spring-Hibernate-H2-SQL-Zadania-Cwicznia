package arch.company;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyControler {
    private final CompanyService companyService;

    public CompanyControler(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/{id}")
    ResponseEntity<CompanyDto> getCompanyById(@PathVariable Long id) {
        return companyService.getCompanyById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/offers")
    ResponseEntity<List<CompanyJobOfferDto>> getJobOffersByCompanyId(@PathVariable Long id) {
        if (companyService.getCompanyById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(companyService.getJobOffersByCompanyId(id));

    }

    @PostMapping
    ResponseEntity<CompanyDto> saveCompany(@RequestBody CompanyDto company){
        CompanyDto savedCompany = companyService.saveCompany(company);
        URI savedUri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedCompany.getId())
                .toUri();
        return ResponseEntity.created(savedUri).body(savedCompany);
    }

    @PutMapping("/{id}")
    ResponseEntity<?> replaceCompany(@PathVariable Long id, @RequestBody CompanyDto company){
        return companyService.replaceCompany(id, company)
                .map(c -> ResponseEntity.noContent().build())
                .orElse(ResponseEntity.notFound().build());
    }

}
