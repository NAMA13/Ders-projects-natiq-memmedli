package az.developia.computershopping.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message="Bos qoymaq olmaz!!")
	@Size(min=2,message="Minimum 2 simvol yazmag lazimdir!!")
	@Size(max=25,message="Maksimum 25 simvol yazmag lazimdir!!")
	@Column(columnDefinition = "VARCHAR(25)")
	private String name;

	
	@NotEmpty(message="Bos qoymaq olmaz!!")
	@Size(min=2,message="Minimum 2 simvol yazmag lazimdir!!")
	@Size(max=25,message="Maksimum 25 simvol yazmag lazimdir!!")
	@Column(columnDefinition = "VARCHAR(25)")
	private String username;
	
	@NotEmpty(message="Bos qoymaq olmaz!!")
	@Size(min=2,message="Minimum 2 simvol yazmag lazimdir!!")
	@Size(max=25,message="Maksimum 25 simvol yazmag lazimdir!!")
	@Column(columnDefinition = "VARCHAR(25)")
	private String password;

	@NotEmpty(message="Bos qoymaq olmaz!!")
	@Pattern(regexp="((\\(\\d{3}\\) ?)|(\\d{3}-))?\\d{3}-\\d{4}",message="Telefonu duzgun formatda yazin.Meselen : 000-000-0000")
	@Column(columnDefinition = "VARCHAR(20)")
	private String phone;
}

