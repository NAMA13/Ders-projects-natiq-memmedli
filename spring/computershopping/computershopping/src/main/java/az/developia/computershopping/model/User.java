package az.developia.computershopping.model;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer id;

	@Size(min=2,message="Istifadeci adi minimum 2 simvol olmalidir")
	@Size(max=30,message="Istifadeci adi maksimum 30 simvol olmalidir")
	@NotEmpty(message="Bos qoymaq olmaz!!")
	private String username;

	@Size(min=2,message="Sifre minimum 2 simvol olmalidir")
	@Size(max=30,message="Sifre maksimum 30 simvol olmalidir")
	@NotEmpty(message="Bos qoymaq olmaz!!")
	private String password;

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
	
}