package az.developia.springcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import az.developia.springcore.basqa.Home;

@SpringBootApplication

// @Configuration
// @ComponentScan
// @EnableAutoConfiguration

public class SpringCoreApplication {
	// component scan
	// component
	// bean
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringCoreApplication.class, args);

//		Book myBook = context.getBean(Book.class);
//		System.out.println(myBook );
//
//		Book myBook2 = context.getBean(Book.class);
//		System.out.println(myBook2 );

		Car car1 = context.getBean(Car.class);
		System.out.println(car1);

		Car car2 = context.getBean(Car.class);
		System.out.println(car2);

		// MyConfig s = context.getBean( MyConfig.class); // bean
		// System.out.println(s.getMyCompany());

		// Student s = context.getBean("telebem",Student.class); // bean
		// System.out.println(s);

		// Home h = context.getBean(Home.class); // bean
		// System.out.println(h);

		// s.setName("Uzeyir");

		// Student s1 = context.getBean(Student.class);
		// System.out.println(s1 );

//		String[] beans = context.getBeanDefinitionNames();
//		for (String b : beans) {
//			System.out.println(b);
//		}

	}

}
