package az.developia.springcore;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component

public class Computer {
	@Override
	public String toString() {
		return "Computer [id=" + id + ", brand=" + brand + ", price=" + price + ", color=" + color + "]";
	}
	private int id;
	private String brand;
	private double price;
	private String color;
	public Computer() {
		id = 1;
		brand = "Lenovo";
		price = 4599.99;
		color = "Dark";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	

	@PostConstruct
	private void init() {
		toString();
		System.out.println("init");
	}
	@PreDestroy
	private void destroy() {
		toString();
		System.out.println("destroy");
	}
}
