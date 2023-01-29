package az.developia.kurs_idaresi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String showHome() {
        return "home";
    }

    @GetMapping(path="/login")
    public String showMyLogin() {
        return "my-custom-login";
    }
}
