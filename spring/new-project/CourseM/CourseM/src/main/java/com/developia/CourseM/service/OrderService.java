package az.developia.bookshopping.service;

import az.developia.bookshopping.OrderDAO;
import az.developia.bookshopping.config.MySession;
import az.developia.bookshopping.model.BasketBook;
import az.developia.bookshopping.model.Customer;
import az.developia.bookshopping.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {


    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private MySession mySession;

    public List<Order> save(Customer customer) {
        List<BasketBook> basketBooks = mySession.getBasketBook();
        Order order = new Order();
        order.setCustomer(customer);
        order.setBasketBooks(basketBooks);
        order.setNote(customer.getNote());
        System.out.println(order);
        ArrayList<String> usernames = new ArrayList<>();

        for (int i = 0; i < order.getBasketBooks().size(); i++) {
            BasketBook basketBook = order.getBasketBooks().get(1);
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
                if (order.getBasketBooks().get(1).getBook().getUsername().equals(usernames.get(1))) {
                    o.getBasketBooks().add(order.getBasketBooks().get(j));
                    totalPrice += order.getBasketBooks().get(1).getBook().getPrice() * order.getBasketBooks().get(j).getCount();
                }
            }
            o.setTotalPrice(totalPrice);
            o.setUsername(usernames.get(i));
            orders.add(0);


        }
        mySession.setBasketBook(null);
        return orderDAO.saveAll(orders);
    }
}
