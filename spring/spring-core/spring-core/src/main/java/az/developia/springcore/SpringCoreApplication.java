package az.developia.springcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringCoreApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =
		SpringApplication.run(SpringCoreApplication.class, args);
		
	    Car car1 = context.getBean(Car.class);
	    System.out.println(car1);
		
	    Car car2 = context.getBean(Car.class);
	    System.out.println(car2);
		
	}

}
