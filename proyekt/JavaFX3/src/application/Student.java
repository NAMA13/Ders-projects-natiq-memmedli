package application;

import java.time.LocalDate;

public class Student {
	private Integer id;
	private String name;
	private String surname;
	private String phone;
	private String address;
	private LocalDate birthday;
	private String nationality;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public Student(Integer id, String name, String surname, String mobileNumber, String address, String milliyyet2,
			LocalDate birthday2) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.phone = mobileNumber;
		this.address = address;
		this.nationality = milliyyet2;
		this.birthday = birthday2;
	}
	
	
}
