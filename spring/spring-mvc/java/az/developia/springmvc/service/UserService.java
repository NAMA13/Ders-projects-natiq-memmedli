package az.developia.springmvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.springmvc.exceptions.ComputerNotFoundException;
import az.developia.springmvc.model.Computer;
import az.developia.springmvc.model.UserModel;
import az.developia.springmvc.repository.ComputerRepository;
import az.developia.springmvc.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
 

	public void save(UserModel user) {
		repository.save(user);
	}
 
}