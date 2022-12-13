package bikerent;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Bike {
    @Id
    private Long id;
    private String model;
    private String serialNO;
    private double hourPrice;
    private double dayPrice;
    private String borrowedId;
private LocalDateTime dataOfReturn;
    public Bike() {
    }

    public Bike(Long id, String model, String serialNO, double hourPrice, double dayPrice) {
        this.id = id;
        this.model = model;
        this.serialNO = serialNO;
        this.hourPrice = hourPrice;
        this.dayPrice = dayPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNO() {
        return serialNO;
    }

    public void setSerialNO(String serialNO) {
        this.serialNO = serialNO;
    }

    public double getHourPrice() {
        return hourPrice;
    }

    public void setHourPrice(double hourPrice) {
        this.hourPrice = hourPrice;
    }

    public double getDayPrice() {
        return dayPrice;
    }

    public void setDayPrice(double dayPrice) {
        this.dayPrice = dayPrice;
    }

    public String getBorrowedId() {
        return borrowedId;
    }

    public void setBorrowedId(String borrowedId) {
        this.borrowedId = borrowedId;
    }

    public LocalDateTime getDataOfReturn() {
        return dataOfReturn;
    }

    public void setDataOfReturn(LocalDateTime dataOfReturn) {
        this.dataOfReturn = dataOfReturn;
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
                ", dataOfReturn=" + dataOfReturn +
                '}';
    }
}
