package az.developia.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserModel {
	private String name;
	
	private String surname;
	  
	private String username;
	private String password;
	
	
	 
}