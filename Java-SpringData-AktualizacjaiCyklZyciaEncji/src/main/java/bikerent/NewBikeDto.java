package bikerent;

public class NewBikeDto {
    private Long id;
    private String model;
    private String serialNO;
    private double hourPrice;
    private double dayPrice;

    public NewBikeDto(Long id, String model, String serialNO, double hourPrice, double dayPrice) {
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
}
