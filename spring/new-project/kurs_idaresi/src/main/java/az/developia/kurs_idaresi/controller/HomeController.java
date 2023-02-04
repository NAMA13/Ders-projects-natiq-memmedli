package az.developia.kurs_idaresi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @GetMapping
    public String showHome() {
        return "home";
    }

    @GetMapping(path="/login")
    public String showMyLogin() {
        return "my-login";
    }

    @GetMapping(path = "/logout")
    public String logOut(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    @GetMapping(path = "/mainpage")
    public String showMainPage() {
        return "main-table";
    }
}
