package az.developia.springmvc.repository;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import az.developia.springmvc.model.Computer;


@Repository
public interface ComputerRepository extends JpaRepository<Computer, Integer> {
	
	// select * from computers where name='Lenovo';
	List<Computer> findAllByBrand(String brand);// query method
	List<Computer> findAllByModel(String model);
	
	// native query
	@Query(value = "select * from computers where brand like %?1%;",nativeQuery = true)
	List<Computer> neIstesekQoyaBilerik(String brand);
	
	

}