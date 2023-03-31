package az.developia.bookshopping.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String note;

    @CreationTimestamp
    private Timestamp register;

    private Double totalPrice;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<BasketBook> basketBooks;

    private String username;


    public List<BasketBook> getBasketBooks() {
        if(basketBooks==null){
            basketBooks=new ArrayList<BasketBook>();
        }
        return basketBooks;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", note='" + note + '\'' +
                ", register=" + register +
                ", totalPrice=" + totalPrice +
                ", customer=" + customer +
                ", basketBooks=" + basketBooks +
                ", username='" + username + '\'' +
                '}';
    }
}