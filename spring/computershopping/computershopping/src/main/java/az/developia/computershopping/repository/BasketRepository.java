package az.developia.computershopping.repository;

import az.developia.computershopping.model.Basket;
import az.developia.computershopping.model.BasketComputer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Integer> {
}
