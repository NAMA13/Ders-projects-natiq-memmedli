package az.developia.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springmvc.model.AuthorityModel;

public interface AuthorityRepository extends JpaRepository<AuthorityModel, Integer> {
	
}