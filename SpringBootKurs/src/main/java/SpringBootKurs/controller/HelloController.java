package SpringBootKurs.controller;

import SpringBootKurs.model.HelloResponse;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public HelloResponse hello(@AuthenticationPrincipal User user) {
        return new HelloResponse("Hello " + user.getUsername());
    }
}
