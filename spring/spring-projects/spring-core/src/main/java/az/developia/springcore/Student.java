package az.developia.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component(value = "telebem")
// @Primary
// @Scope(scopeName = "singleton")
public class Student {
	private int id;
	private String name;

	@Autowired
	 @Qualifier(value = "myContact")
	private Contact contact; // has-a
	// elaqe, myContact

	public Student() {
		id = 100;
		name = "Natiq";

		//System.out.println("Student sinifinden obyekt yaranir");
	}

	public Student(int id) {
		this.id = id;
	}

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

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", contact=" + contact + "]";
	}

}
