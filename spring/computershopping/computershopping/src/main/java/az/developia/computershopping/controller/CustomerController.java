package az.developia.computershopping.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import az.developia.computershopping.config.MySession;
import az.developia.computershopping.dao.ComputerDAO;
import az.developia.computershopping.model.Computer;
import az.developia.computershopping.dao.ComputerDAO;

@Controller
public class CustomerController {

	@Autowired
	private ComputerDAO computerDAO;
	
	@Autowired
	private MySession mySession;

}