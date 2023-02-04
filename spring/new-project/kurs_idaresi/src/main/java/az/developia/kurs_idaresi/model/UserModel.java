package az.developia.kurs_idaresi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="users")
@Entity


public class UserModel {
    @Id
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String surname;
    private Integer enabled;
}