package bikerent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class BikerentApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BikerentApplication.class, args);
        BikeService bikeService = context.getBean(BikeService.class);
        NewBikeDto bike1 = new NewBikeDto(1L, "AKASO", "1234PL", 80, 150);
        NewBikeDto bike2 = new NewBikeDto(2L, "KATO", "332WD", 60, 110);
        bikeService.add(bike1);
        bikeService.add(bike2);
        double paymentH = bikeService.rentForHours(1L, 4, "ANNA");
        double paymentD = bikeService.rentForDay(2L, "KRISTOPER");
        System.out.println("wypożyczenie roweru kosztowało " + paymentH);
        System.out.println("wypożyczenie roweru kosztowało " + paymentD);
        bikeService.returnBike(1L);



    }

}
