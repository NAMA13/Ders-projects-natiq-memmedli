package com.developia.CourseM.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NotFound;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty(message="Not Empty!")
	@Size(max=30, message= "Max 30 caracter!" )
	@Column(columnDefinition = "VARCHAR(30)")
	private String name;
	@Size(max=30, message= "Max 500 caracter!" )
	@Column(columnDefinition = "VARCHAR(500)")
	private String description;
	@Min(value=0, message="Price must not be least than 0!")
	@Max(value=99999, message="Price must not be more than 0!")
	@NotNull(message = "Must not be empty!")
	private Double price; 
	@Size(max=50, message="Must not be more than 50!")
	private String author;
	@Min(value=0, message="Price must not be least than 0!")
	@Max(value=99999, message="Price must not be more than 999999!")
	private Integer pageCount;
	private String image; 
	private String username;
}
