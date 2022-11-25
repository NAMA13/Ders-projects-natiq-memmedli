package az.developia.springcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringCoreApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =
		SpringApplication.run(SpringCoreApplication.class, args);
		Employee s = context.getBean(Employee.class);
		System.out.println(s);
		
	}

}
