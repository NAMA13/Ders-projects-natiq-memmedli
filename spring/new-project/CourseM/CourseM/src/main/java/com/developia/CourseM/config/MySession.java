package az.developia.bookshopping.config;

import az.developia.bookshopping.model.BasketBook;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MySession {
    private String username;
    private List<BasketBook> basketBook;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public MySession(){
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();

        setUsername(loggedInUser.getName());
        System.out.println(username);

    }

    public List<BasketBook> getBasketBook() {
        return basketBook;
    }

    public void setBasketBook(List<BasketBook> basketBook) {
        this.basketBook = basketBook;
    }

    @PostConstruct
    public void initsession(){
        System.out.println("MySession>initSession");
    }

    @PreDestroy
    public void destroySession(){
        System.out.println("MySession>destroySession");
    }
}
