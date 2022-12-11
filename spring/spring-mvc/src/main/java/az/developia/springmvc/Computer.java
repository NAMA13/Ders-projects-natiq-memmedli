package az.developia.springmvc;

import java.sql.Date;

public class Computer {

	private Integer id;
	private String model;
	private String brand;
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
