package az.developia.bookshopping;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.bookshopping.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookDAO extends JpaRepository<Book, Integer> {
    public List<Book> findAllByUsername(String username);

    @Query(value="SELECT * FROM book WHERE name LIKE %:searchTerm%", nativeQuery=true)
    public List<Book> findAllSearch(@Param("searchTerm") String searchTerm);

    @Query(value="SELECT * FROM book WHERE name LIKE %:searchTerm% OR description LIKE %:searchTerm% OR price LIKE %:searchTerm% OR page_count LIKE %:searchTerm% OR author LIKE %:searchTerm%", nativeQuery=true)
    public List<Book> findAllSearchAllFields (@Param("searchTerm") String searchTerm);


}
 