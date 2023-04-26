package az.developia.computershopping.repository;

import az.developia.computershopping.model.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ComputerRepository extends JpaRepository<Computer, Integer> {

    @Query(value = "SELECT * FROM computers WHERE username LIKE %?1%", nativeQuery = true)
    List<Computer> findAllByUsername(String username);

    @Query(value = "SELECT * FROM computers WHERE category LIKE %?1%", nativeQuery = true)
    List<Computer> findAllByCategory(String category);

}