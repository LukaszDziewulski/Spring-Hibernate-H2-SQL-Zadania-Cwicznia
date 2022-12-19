package emailapp;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented                                              // adnotacja bedzie przechowwywama w dokumentacji
@Constraint(validatedBy = CustomValidator.class)         // wskazuje ze jest to adnotacja ograniczenia standartu JAKARTA BEAN VALIDATION
@Target({FIELD, PARAMETER})                              // ograniczenie stosowane do pol klasy i parametrow
@Retention(RUNTIME)                                      // adnotacja bedzie wykorzystywana w stanie wykonania
public @interface CustomConstraint {
    String message() default "Value is invalid";              // komunikat błędu

    Class<?>[] groups() default {};                         //grupa pozwala okreslic kolejnosc w jakiej ograniczenia beda weryfikowane

    Class<? extends Payload>[] payload() default {};     // rzadko wykorzystywane ale konieczne
}


