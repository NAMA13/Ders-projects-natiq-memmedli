package todolist;

import java.time.LocalDate;



public class Task {
	private int id; // +
	private int userId; //
	private String name; //
	private LocalDate qeydiyyat;
	private String gun; //
	private String category; //
	private String status; //
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getGun() {
		return gun;
	}

	public void setGun(String gun) {
		this.gun = gun;
	}
	public LocalDate getQeydiyyat() {
		return qeydiyyat;
	}

	public void setQeydiyyat(LocalDate qeydiyyat) {
		this.qeydiyyat = qeydiyyat;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}




	public Task(int id, String name, String gun, LocalDate qeydiyyat, String category, int userId, String status) {
		super();
		this.id = id;
		this.name = name;
		this.userId = userId;
		this.category = category;
		this.gun = gun;
		this.qeydiyyat = qeydiyyat;
		this.status = status;
	}

	
	
}
