package sec;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginControler {
    @GetMapping("/logowanie")
    String loginForm(){
        return "login-form";
    }
}
