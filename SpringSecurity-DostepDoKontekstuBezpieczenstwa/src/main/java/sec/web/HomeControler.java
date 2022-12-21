package sec.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sec.message.WelcomeMessageService;

@Controller
public class HomeControler {

    WelcomeMessageService welcomeMessageService;

    public HomeControler(WelcomeMessageService welcomeMessageService) {
        this.welcomeMessageService = welcomeMessageService;
    }

    @GetMapping("/")
    String home(@RequestParam(defaultValue =  "en")String lang, Model model) {
        String welcomeMessage = welcomeMessageService.getWelcomeMessage(lang);
        model.addAttribute("welcomeMessage",welcomeMessage);
        return "index";
    }
}
