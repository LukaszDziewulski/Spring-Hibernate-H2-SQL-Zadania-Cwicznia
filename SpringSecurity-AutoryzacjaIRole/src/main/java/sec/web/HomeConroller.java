package sec.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeConroller {
    @GetMapping("/")
    String home() {
        return "index";
    }
}
