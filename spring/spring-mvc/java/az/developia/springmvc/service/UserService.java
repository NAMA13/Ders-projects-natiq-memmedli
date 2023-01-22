package az.developia.springmvc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import az.developia.springmvc.exceptions.ComputerNotFoundException;
import az.developia.springmvc.model.AuthorityModel;
import az.developia.springmvc.model.Computer;
import az.developia.springmvc.model.UserModel;
import az.developia.springmvc.repository.ComputerRepository;
import az.developia.springmvc.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;

	@Autowired
	private AuthorityService authorityService;

	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	public void save(UserModel user) {
		user.setPassword("{bcrypt}" + encoder.encode(user.getPassword()));
		user.setEnabled(1);
		repository.save(user);

		AuthorityModel studentGetAll = new AuthorityModel();
		studentGetAll.setUsername(user.getUsername());
		studentGetAll.setAuthority("student:get:all");
		authorityService.saveAuthority(studentGetAll);

	}

	public List<UserModel> findAll() {
		return repository.findAll();
	}
}