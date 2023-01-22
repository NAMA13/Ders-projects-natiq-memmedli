package az.developia.springmvc.repository;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import az.developia.springmvc.model.Computer;
import az.developia.springmvc.model.UserModel;
 
public interface UserRepository extends JpaRepository<UserModel, String> { 
	
}