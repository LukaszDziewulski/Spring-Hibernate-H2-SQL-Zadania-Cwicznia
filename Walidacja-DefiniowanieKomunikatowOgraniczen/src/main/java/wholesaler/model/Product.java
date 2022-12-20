package wholesaler.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import wholesaler.constraint.SerialNo;

@Data
@AllArgsConstructor
public class Product {

    private String name;
    private String description;
    @SerialNo(startsWith = "PL", codeLength = 5)
    private String serialNumber;
}
