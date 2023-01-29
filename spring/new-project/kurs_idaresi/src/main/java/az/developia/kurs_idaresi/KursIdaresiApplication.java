package az.developia.kurs_idaresi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class KursIdaresiApplication {


	public static void main(String[] args) {
		SpringApplication.run(KursIdaresiApplication.class, args);
	}

}
