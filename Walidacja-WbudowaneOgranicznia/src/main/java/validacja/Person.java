package validacja;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.URL;
import org.hibernate.validator.constraints.pl.PESEL;

import java.time.LocalDate;
@Data
@AllArgsConstructor

public class Person {
    @NotNull
    @Size(min = 2)
    private String firstName;
    @NotNull
    @Size(min = 2)
    private String lastName;
    @PESEL
    private String pesel;
    @Past
    private LocalDate birthday;
    @Email
    private String email;
    @NotNull
    @Size(min = 5)
    private String password;
    @URL
    private String blogUrl;
}
