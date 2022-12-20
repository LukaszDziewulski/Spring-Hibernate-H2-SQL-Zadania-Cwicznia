package wholesaler;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import wholesaler.model.Equipment;
import wholesaler.model.Product;

import java.util.Set;

@SpringBootApplication
public class WholesalerApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(WholesalerApplication.class, args);
        Validator validator = context.getBean(Validator.class);

        Product product1 = new Product("Dell XPS 15", "Laptop 15 calowy z 2021 roku", "PI13243");

        Set<ConstraintViolation<Product>> productContrainValidations = validator.validate(product1);
        if (!productContrainValidations.isEmpty()){
            System.out.println("Nieprawidłowy produkt, złamanie ograniczenia");
            productContrainValidations.stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
        }

        Equipment equipment1 = new Equipment("iPhone 13", "KARNOW123", "EQ72986");
        Set<ConstraintViolation<Equipment>> equipmentConstraintViolations = validator.validate(equipment1);
        if (!equipmentConstraintViolations.isEmpty()) {
            System.out.println("Nieprawidłowe wyposażenie, złamane ograniczenia:");
            equipmentConstraintViolations.stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
        }


    }

}
