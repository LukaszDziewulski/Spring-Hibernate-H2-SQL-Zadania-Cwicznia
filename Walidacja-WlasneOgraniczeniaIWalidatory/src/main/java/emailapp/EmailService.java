package emailapp;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class EmailService {
    private Validator validator;

    public EmailService(Validator validator) {
        this.validator = validator;
    }
    public void sendMessage(EmailMessage email){
        System.out.println("Sending email...");
        Set<ConstraintViolation<EmailMessage>> validate = validator.validate(email);
        if (validate.isEmpty()){
            System.out.println("Message has been sent succesfully");
        }else {
            System.out.println("Message contains errors");
            for (ConstraintViolation<EmailMessage> violation : validate) {
                System.out.println(violation.getPropertyPath() + " : " + violation.getMessage());
            }
        }
    }
}
