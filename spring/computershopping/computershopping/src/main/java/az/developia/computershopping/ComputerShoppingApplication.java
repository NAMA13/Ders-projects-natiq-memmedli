package az.developia.computershopping;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import az.developia.computershopping.file.StorageService;


@SpringBootApplication
public class ComputerShoppingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComputerShoppingApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.init();
		};
	}

}
