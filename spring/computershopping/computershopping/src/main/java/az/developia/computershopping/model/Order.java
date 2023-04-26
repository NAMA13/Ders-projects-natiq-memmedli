package az.developia.computershopping.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@ToString
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @OneToMany
    public List<Basket> basketComputers;

    @CreationTimestamp
    public Timestamp register;

    @Column(name = "customerId")
    public Integer customer;

    @Column(name = "total_price")
    public Double totalPrice;

    @Column(name = "note")
    public String note;

    @Column(name = "username")
    public String username;

    @Column(name = "email")
    public String email;

    @Column(name = "phoneNumber")
    public String number;

    @Column(name = "adress")
    public String adress;

    @Column(name = "name")
    public String name;

    // getters and setters

}
