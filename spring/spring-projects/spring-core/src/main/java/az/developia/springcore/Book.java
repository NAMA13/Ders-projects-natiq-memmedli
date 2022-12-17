package az.developia.springcore;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

 @Component // default scopu singleton dur
 // @Scope(scopeName = "prototype")
 @Scope(scopeName = "singleton")
public class Book {

	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Book(int id, String name) {

		this.id = id;
		this.name = name;
	}

	public Book() {
		System.out.println("book obyekti yarandi");
		id = 12;
		name = "Python";
	}

	@PostConstruct
	private void init() {
		System.out.println("book init metodu");
		System.out.println("bazani aciram");
	}

	@PreDestroy
	private void destroy() {
		System.out.println("book destroy metodu");
		System.out.println("bazani bagliyiram");
	}

}
