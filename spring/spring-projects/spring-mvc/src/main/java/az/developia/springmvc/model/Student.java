package az.developia.springmvc.model;

import java.sql.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import az.developia.springmvc.annotation.OurBestAnnotation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
	private Integer id;
	@Size(min = 3, message = "Tələbə adı minimum 3 simvol olmalıdır!!!")
	@NotEmpty(message = "Boş qoymaq olmaz - NotEmpty")
	@NotBlank(message = "Boş qoymaq olmaz - NotBlank")
	@NotNull(message = "Ad mütləqdir")
	private String name;
	private String surname;
	@Past(message = "Tevellud mutleq kecmis zaman olmalidir")
	private Date birthday;
	
	
	private String sector;
	
	@Min(value = 50, message = "Telebeye minimum 50 xal verilmelidir")
	@Max(value = 100, message = "Telebeye maksimum 100 xal verilmelidir")
	@NotNull(message = "Qiymet mütləqdir")
	private Integer point;
	@Pattern(regexp = "[a-z0-9_.]+@[a-z0-9]+\\.[a-z]{2,4}", message = "Email dogru formatda yazilmalidir, meselen: myemail@email.com")
	@OurBestAnnotation(value = "face",message = "email face ile baslamalidir")
	private String email;
	@Pattern(regexp = "[0-9]{3}-[0-9]{3}-[0-9]{4}", message = "Telefon duz yazilmadi, duz format -> 000-000-0000")
	
	private String phone;
}
