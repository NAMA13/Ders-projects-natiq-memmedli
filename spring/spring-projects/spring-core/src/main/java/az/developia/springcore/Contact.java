package az.developia.springcore;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component(value = "elaqe")
 @Primary
public class Contact {

	private String address;
	private String phone;
	private String email;

	public Contact() {
		address = "Baku";
		phone = "4321";
		email = "eli@email.com";
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Contact(String address, String phone, String email) {
		super();
		this.address = address;
		this.phone = phone;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contact [address=" + address + ", phone=" + phone + ", email=" + email + "]";
	}

}
