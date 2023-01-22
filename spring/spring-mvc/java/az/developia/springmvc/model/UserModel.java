package az.developia.springmvc.model;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("deprecation")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="users")
public class UserModel {
	@Id

	@Size(min = 2, max = 25, message = "Cannot be less than 2 characters!")
	@NotEmpty(message = "Cannot be empty")
	private String name;

	@Size(min = 2, max = 25, message = "Cannot be less than 2 characters!")
	@NotEmpty(message = "Cannot be empty")
	private String surname;

	private String username;
	private String password;

	private Integer enabled;	

}