package az.developia.springcore;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = "prototype")
public class Car {
	private int price;
	private String model;
	
	public Car(){
		price=12000;
		model="Nese";
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	@PostConstruct
	private void init() {
		System.out.println("car posted");
	}
	@PreDestroy
	private void destroy() {
		System.out.println("car destroyed");
	}
}
