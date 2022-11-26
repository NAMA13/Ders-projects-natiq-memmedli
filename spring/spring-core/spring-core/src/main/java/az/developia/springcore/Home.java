package az.developia.springcore;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Home {
	private int id;
	private String address;
	private String color;
	public Home(int id, String address, String color) {
		super();
		this.id = id;
		this.address = address;
		this.color = color;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getColor() {
		return color;
	}
	@Override
	public String toString() {
		return "Home [id=" + id + ", address=" + address + ", color=" + color + "]";
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
