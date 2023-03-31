package az.developia.bookshopping;

import az.developia.bookshopping.model.Book;
import az.developia.bookshopping.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDAO extends JpaRepository<Order, Integer> {
    public List<Order> findAllByUsername(String username);
}
 