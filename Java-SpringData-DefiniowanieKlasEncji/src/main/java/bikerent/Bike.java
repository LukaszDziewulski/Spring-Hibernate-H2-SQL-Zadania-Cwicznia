package bikerent;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Bike {
    @Id
    private Long id;
    private String model;
    private String serialNO;
    private double hourPrice;
    private double dayPrice;
    private String borrowedId;

    public Bike() {
    }

    public Bike(Long id, String model, String serialNO, double hourPrice, double dayPrice) {
        this.id = id;
        this.model = model;
        this.serialNO = serialNO;
        this.hourPrice = hourPrice;
        this.dayPrice = dayPrice;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", serialNO='" + serialNO + '\'' +
                ", hourPrice=" + hourPrice +
                ", dayPrice=" + dayPrice +
                ", borrowedId='" + borrowedId + '\'' +
                '}';
    }
}
