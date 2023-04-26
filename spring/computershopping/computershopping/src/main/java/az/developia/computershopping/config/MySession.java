package az.developia.computershopping.config;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import az.developia.computershopping.model.BasketComputer;
import lombok.Getter;
import lombok.Setter;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Getter
@Setter
@Qualifier
public class MySession {
	
	private String username;
	
	private List<BasketComputer> basketComputers;
	
	public MySession() {
		Authentication loggedInUser  = SecurityContextHolder.getContext().getAuthentication();
		String username = loggedInUser.getName();
		System.out.println(username);

		this.username = username;

	}
	
	@PostConstruct
	public void initSession() {
		System.out.println("MySession > initSession");
	}
	
	@PreDestroy
	public void destroySession() {
		System.out.println("MySession > destroySession");
	}
	
	
}
