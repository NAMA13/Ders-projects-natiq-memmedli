package az.developia.computershopping.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.computershopping.model.Customer;

public interface CustomerDAO extends JpaRepository<Customer,Integer>{
	
	public Customer findByPhone(String phone);
	public Customer findByUsername(String username);

}
