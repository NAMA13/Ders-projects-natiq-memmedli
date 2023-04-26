package az.developia.computershopping.controller;

import az.developia.computershopping.dao.ComputerDAO;
import az.developia.computershopping.model.Basket;
import az.developia.computershopping.model.Computer;
import az.developia.computershopping.model.Order;
import az.developia.computershopping.repository.BasketRepository;
import az.developia.computershopping.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BasketController {

    @Autowired
    private BasketRepository basketRepository;

    @Autowired
    private ComputerDAO computerDAO;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/show-shopping")
    public String showShoppingPage(Model model) {
        List<Basket> items = getBasketItems();
        List<Computer> computers = computerDAO.getAllComputers();
        model.addAttribute("computers", computers);
        model.addAttribute("items", items);
        model.addAttribute("order", new Order());
        return "shopping";
    }



    @PostMapping("/add")
    public String addToBasket(@RequestParam("id") Integer id,
                              @RequestParam("image") String image,
                              @RequestParam("name") String name,
                              @RequestParam("price") Long price,
                              @RequestParam("quantity") int quantity,
                              Model model) {
        List<Basket> items = getBasketItems();
        boolean itemExists = false;
        for (Basket item : items) {
            if (item.getId().equals(id)) {
                item.setQuantity(item.getQuantity() + quantity);
                basketRepository.save(item);
                itemExists = true;
                break;
            }
        }
        if (!itemExists) {
            Basket item = new Basket();

            item.setImage(image);
            item.setName(name);
            item.setPrice(price);
            item.setQuantity(quantity);
            basketRepository.save(item);
        }
        return "redirect:/basket/show-shopping";
    }



    private List<Basket> getBasketItems() {
        return basketRepository.findAll();
    }
}
