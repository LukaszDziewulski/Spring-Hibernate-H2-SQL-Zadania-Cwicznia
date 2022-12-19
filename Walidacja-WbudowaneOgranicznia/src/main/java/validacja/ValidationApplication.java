package validacja;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;
import java.util.Set;

@SpringBootApplication
public class ValidationApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ValidationApplication.class, args);
        Validator validator = context.getBean(Validator.class);
        Person person = new Person(
                "J",
                "Kowalski",
                "8704127815",
                LocalDate.of(2030, 4, 12),
                "jankowalski.xyz",
                "Qw7",
                "htts://kowalski.xyz"
        );

        Set<ConstraintViolation<Person>> errors = validator.validate(person);
        if (!errors.isEmpty()) {
            System.out.println(">>>obiekt nie może być dodany, lista błędów:");
            errors.forEach(err ->
                    System.out.printf(">>> %s %s (%s)\n",
                            err.getPropertyPath(),
                            err.getMessage(),
                            err.getInvalidValue()));
        } else {
            System.out.println("dane są poprawne");
        }
    }
}


