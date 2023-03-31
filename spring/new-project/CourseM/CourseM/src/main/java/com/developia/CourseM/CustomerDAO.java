package az.developia.bookshopping;

import az.developia.bookshopping.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDAO extends JpaRepository<Customer, Integer> {
    public Customer findByPhone(String phone);

    public Customer findByEmail(String email);
}
