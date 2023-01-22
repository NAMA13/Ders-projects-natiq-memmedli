package az.developia.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import az.developia.springmvc.model.AuthorityModel;
import az.developia.springmvc.repository.AuthorityRepository;
@Service
public class AuthorityService {
	
	@Autowired
	private AuthorityRepository repository;
	public void saveAuthority(AuthorityModel authority) {
		 repository.save(authority);
		
	}
	
	
}