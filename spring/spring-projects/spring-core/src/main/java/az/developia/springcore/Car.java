package az.developia.springcore;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
// bu component sinifin skopunu singleton et, 
// bu component sinifin skopunu prototype et
@Scope(scopeName = "prototype")
public class Car {
	private int price;
	private String model;

	public Car() {
		price = 12000;
		model = "tesla";
	}
	
	@PostConstruct
	private void init() {
		System.out.println("car init");
	}
	
	@PreDestroy
	private void destroy() {
		System.out.println("car destroy");
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

}
