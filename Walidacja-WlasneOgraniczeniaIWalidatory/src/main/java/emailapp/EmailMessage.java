package emailapp;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EmailMessage {
    @NotNull
    @Email
    private String sender;
    @NotNull
    @Email
    private String recipient;
    @NotBadWord(lang = {Lang.PL,Lang.EN})
    private String message;
}
