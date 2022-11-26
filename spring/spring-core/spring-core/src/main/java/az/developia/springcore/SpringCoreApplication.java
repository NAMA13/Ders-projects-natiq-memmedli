package az.developia.springcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringCoreApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =
		SpringApplication.run(SpringCoreApplication.class, args);
		
	    Computer comp1 = context.getBean(Computer.class);
		System.out.println(comp1);
		
		
		Home home1 = context.getBean(Home.class);
		System.out.println(home1);

	    Home home2 = context.getBean(Home.class);
		System.out.println(home1);
	}

}
