package az.developia.kurs_idaresi.controller;

import az.developia.kurs_idaresi.model.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/users")
public class UserController {
    @GetMapping(path = "/create-account")
    public String showSavePage(Model model) {

        UserModel user = new UserModel();

        model.addAttribute("user", user);

        return "home";
    }


}


