package az.developia.springcore;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MyConfig {
	
	@Value(value = "${companyName}")
	private String myCompany;
	 

	public String getMyCompany() {
		return myCompany;
	}

	public void setMyCompany(String myCompany) {
		this.myCompany = myCompany;
	}

	@Bean(name = "menimTelebem")
	@Primary
	public Student myStudent() {
		Student s = new Student();
		s.setId(34);
		s.setName("Uzeyir");

		return s;
	}

	@Bean
	
	public Contact myContact() {
		Contact s = new Contact();
		s.setAddress("Gence");
		s.setEmail("adil@gmail.com");
		s.setPhone("044-434-43434");

		return s;
	}

}
