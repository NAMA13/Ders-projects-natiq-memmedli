package az.developia.bookshopping.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.List;
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message="Boş qoymaq olmaz")
    @Size(min=2, message="Minimum 2 simvol yazmaq lazımdır")
    @Size(max=30, message="Maksimum 30 simvol yazmaq lazımdır")
    @Column(columnDefinition="VARCHAR(30)")
    private String name;
    @NotEmpty(message="Boş qoymaq olmaz")
    @Size(min=2, message="Minimum 2 simvol yazmaq lazımdır")
    @Size(max=30, message="Maksimum zee simvol yazmaq lazımdır")
    @Column(columnDefinition="VARCHAR(200)")
    private String address;
    @NotEmpty(message="Boş qoymaq olmaz")
    @Pattern(regexp="((\\(\\d{3}\\) ?)|(\\d{3}-))?\\d{3}-\\d{4}", message="Telefonu düzgün formada yazın. Masalan: eee-eee-eeee")
    @Column(columnDefinition="VARCHAR(20)")
    @Size(max=20, message="Maksimum 20 simvol yazmaq lazımdır")
    private String phone;
    @NotEmpty(message="Boş qoymaq olmaz")
    @Email(regexp="[a-z0-9. %+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$", message="Emaili düzgün formada yazın")
    @Column(columnDefinition="VARCHAR(100)")
    @Size(max=100, message="Maksimum lee simvol yazmaq lazımdır")
    private String email;
    @Column(columnDefinition="VARCHAR(100)")
    @Size(max=100, message="Maksimum lee simvol yazmaq lazımdır")
    private String note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
