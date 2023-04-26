package az.developia.computershopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.computershopping.model.CategoryModel;



public interface CategoryRepository extends JpaRepository<CategoryModel, Integer> {

	
}