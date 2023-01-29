package az.developia.kurs_idaresi.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import az.developia.kurs_idaresi.Repository.UserRepository;
import az.developia.kurs_idaresi.model.UserModel;


@Service
public class UserService {
	@Autowired
	private UserRepository repository;

//	@Autowired
//	private AuthorityService authorityService;

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

}