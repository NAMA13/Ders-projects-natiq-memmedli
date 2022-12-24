package az.developia.springmvc.model;

import java.sql.Date;
import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class Computer {

	private Integer id;
	
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
	
	
	public java.sql.@Future(message="Date canot be FUTURE time!") Date getDate() {
		return date;
	}
	public void setDate(java.sql.@Future(message="Date canot be FUTURE time!") Date date) {
		this.date = date;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public Computer(int id, String model, String brand, int price, Date date) {
		super();
		this.id = id;
		this.model = model;
		this.brand = brand;
		this.price = price;
		this.date = date;
	}
public Computer() {
	 
}
	@Override
	public String toString() {
		return "Computer [id=" + id + ", model=" + model + ", brand=" + brand + ", price=" + price + ", Date=" + date
				+ "]";
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
}
