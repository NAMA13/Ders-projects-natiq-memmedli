package az.developia.springmvc.model;

import java.sql.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Computer {

	private Integer id;
	
	@Size(min=3,message="Cannot be less than 3 characters!")
	@NotEmpty()
	private String model;
	
	@Size(min=3,message="Cannot be less than 5 characters!")
	@NotEmpty()
	private String brand;
	
	@Min(value=1000, message= "Min $1000")
	@Max(value=20000, message= "Max $20000")
	private int price;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public Computer(Integer id, String model, String brand, int price) {
		super();
		this.id = id;
		this.model = model;
		this.brand = brand;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Computer [id=" + id + ", model=" + model + ", brand=" + brand + ", price=" + price + "]";
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
