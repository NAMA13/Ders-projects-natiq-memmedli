package az.developia.computershopping.controller;


import az.developia.computershopping.model.Order;
import az.developia.computershopping.repository.BasketRepository;
import az.developia.computershopping.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BasketRepository basketRepository;

    @GetMapping(path = "/show-order")
    public String showOrdersPage(Model model) {
        // Assuming that Order is the type of objects stored in the repository
        model.addAttribute("order", orderRepository.findAll());

        System.out.println(orderRepository.findAll());
        System.out.println(basketRepository.findAll());
        return "orders";
    }


    @PostMapping("/show-shopping")
    public String confirmOrder(@ModelAttribute("order") Order order, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "order-form";
        }
        order.setBasketComputers(basketRepository.findAll());

        orderRepository.save(order);

        model.addAttribute("order", order);

        return "index";
    }

    @GetMapping("/orders/{id}")
    public String viewOrder(@PathVariable Long id, Model model) {

        model.addAttribute("order", orderRepository.findById(id));
        return "viewOrder";
    }


}
