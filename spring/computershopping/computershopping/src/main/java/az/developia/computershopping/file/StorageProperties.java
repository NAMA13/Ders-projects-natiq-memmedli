package az.developia.computershopping.file;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties("storage")
@Getter
@Setter
@Component
@Primary
public class StorageProperties {
	private String location = "upload-dir-computer-shopping-spring-ajax";
}
