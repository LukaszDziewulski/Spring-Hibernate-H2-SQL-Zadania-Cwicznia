package wholesaler.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import wholesaler.constraint.SerialNo;
@Data
@AllArgsConstructor
public class Equipment {
    private String name;
    private String userId;
    @SerialNo(startsWith = "EQ", codeLength = 4)
    private String serialNumber;
}
