package bikerent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BikerentApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BikerentApplication.class, args);
        BikeService bikeService = context.getBean(BikeService.class);
        BikeDto bike1 = new BikeDto(1L, "AKASO", "1234PL", 80, 150);
        BikeDto bike2 = new BikeDto(2L, "KATO", "332WD", 60, 110);
        BikeDto bike3 = new BikeDto(3L, "SRAT", "55588", 76, 130);
        BikeDto bike4 = new BikeDto(4L, "OKIŁ", "QQW123", 80, 130);

        bikeService.add(bike1);
        bikeService.add(bike2);
        bikeService.add(bike3);
        bikeService.add(bike4);
        double paymentH = bikeService.rentForHours("1234PL", 4, "ANNA");
        double paymentD = bikeService.rentForDay("55588", "KRISTOPER");
        System.out.println("wypożyczenie roweru kosztowało " + paymentH);
        System.out.println("wypożyczenie roweru kosztowało " + paymentD);
        bikeService.returnBike("1234PL");

        int i = bikeService.countBorrowedBikes();
        System.out.println("Wypozyczonych rowerów jest: " + i);

        bikeService.findAllAvailableBikes().forEach(System.out::println);


    }

}
