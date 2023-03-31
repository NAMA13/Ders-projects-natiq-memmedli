package az.developia.bookshopping.file;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties("storage")
@Getter
@Setter
@Primary
public class StorageProperties {

    private String location = "upload-dir-book-shopping-spring-ajax";

}

