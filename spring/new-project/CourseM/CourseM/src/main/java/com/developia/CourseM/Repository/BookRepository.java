package com.developia.CourseM.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.developia.CourseM.Model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
