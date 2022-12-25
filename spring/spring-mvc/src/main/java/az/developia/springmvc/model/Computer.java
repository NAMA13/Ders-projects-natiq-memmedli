package az.developia.springmvc.model;

import java.sql.Date;
import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Computer {

	private Integer Id;
	
	@Size(min=3,message="Cannot be less than 3 characters!")
	@NotEmpty(message="Cannot be empty")
	private String model;
	
	@Size(min=2,message="Cannot be less than 2 characters!")
	@NotEmpty(message="Cannot be empty")
	private String brand;
	
	@Min(value=1000, message= "Min $1000")
	@Max(value=20000, message= "Max $20000")
	private Integer price;
	
	@Past(message = "Date canot be FUTURE time!")
	private Date date;
	public Computer(int id, String model, String brand, int price, Date date) {
		super();
		this.Id = id;
		this.model = model;
		this.brand = brand;
		this.price = price;
		this.date = date;
	}
}
