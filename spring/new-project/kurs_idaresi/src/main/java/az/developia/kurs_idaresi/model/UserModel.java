package az.developia.kurs_idaresi.model;

import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Entity;
import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class UserModel {
	@Id
	@Size(min = 2, max = 25)
	private String username;
	
	@Size(min = 8, max = 100)
	private String password;
	
	@Size(min = 2, max = 15)
	private String name;
	
	@Size(min = 2, max = 25)
	private String surname;
	
	private Integer enabled;
}