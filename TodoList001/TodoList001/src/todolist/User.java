package todolist;

import java.time.LocalDate;

public class User {
	private Integer id;
	private String username;
	private String ad;
	private Integer password;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}



	public User(Integer id, String username, int password, String ad, String soyad) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.ad = ad;
	}

	
	
}
