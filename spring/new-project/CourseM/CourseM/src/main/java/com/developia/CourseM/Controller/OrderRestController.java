package az.developia.bookshopping.controller;

import az.developia.bookshopping.OrderDAO;
import az.developia.bookshopping.config.MySession;
import az.developia.bookshopping.model.BasketBook;
import az.developia.bookshopping.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/rest/orders")
public class OrderRestController {

    @Autowired
    private OrderDAO orderDAO;

    @GetMapping
    public List<Order> findAll() {
        return orderDAO.findAll();
    }

    @Autowired
    private MySession mySession;

    @PostMapping
    public List<Order> save(@RequestBody Order order) {
        ArrayList<String> usernames = new ArrayList<>();
        for (int i = 0; i < order.getBasketBooks().size(); i++) {
            BasketBook basketBook = order.getBasketBooks().get(i);
            if (usernames.contains(basketBook.getBook().getUsername())) {
            } else {
                usernames.add(basketBook.getBook().getUsername());
            }
        }
        List<Order> orders = new ArrayList<>();
        for (int i = 0; i < usernames.size(); i++) {
            Order o = new Order();
            o.setNote(order.getNote());
            o.setCustomer(order.getCustomer());
            double totalPrice = 0;
            for (int j = 0; j < order.getBasketBooks().size(); j++) {
                if (order.getBasketBooks().get(j).getBook().getUsername().equals(usernames.get(i))) {
                    o.getBasketBooks().add(order.getBasketBooks().get(j));
                    totalPrice += order.getBasketBooks().get(j).getBook().getPrice() * order.getBasketBooks().get(j).getCount();
                }
            }
            o.setTotalPrice(totalPrice);
            o.setUsername(usernames.get(i));
            orders.add(o);
        }
        return orderDAO.saveAll(orders);
    }



    @GetMapping(path = "/{id}")
    public Order findById (@PathVariable(name = "id") Integer id){
        return orderDAO.findById(id).get();
    }


    @GetMapping(path = "/{username}")
    public List<Order> findByUsername (@PathVariable(name = "username") String username){
        return orderDAO.findAllByUsername(username);
    }

    @PostMapping(path="/save-basket-books")
    public Boolean saveBasketBooks (@RequestBody List<BasketBook> basketBooks) {
        System.out.println(basketBooks);
        mySession.setBasketBook(basketBooks);
        return true;
    }
}
