package az.developia.computershopping.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "computers")
//@Getter
//@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Computer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;

	public String image;
	public String name;
	public String description;
	public Integer price;
	public String phone;
	public boolean isNew;
	public Integer ram;
	public String cpu;
	public String drive;
	public String driveType;
	public String os;
	public Integer videoCard;
	public String category;
	public Integer customerId;

	public String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}




	public Computer(Integer id, String image, String name, String description, Integer price, String phone, boolean isNew, int ram,
					String cpu, String drive, String driveType, String os, Integer videoCard) {
		this.id = id;
		this.image = image;
		this.name = name;
		this.description = description;
		this.price = price;
		this.phone = phone;
		this.isNew = isNew;
		this.ram = ram;
		this.cpu = cpu;
		this.drive = drive;
		this.driveType = driveType;
		this.os = os;
		this.videoCard = videoCard;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isNew() {
		return isNew;
	}

	public boolean getIsNew() {
		return isNew;
	}

	public void setNew(boolean aNew) {
		isNew = aNew;
	}

	public Integer getRam() {
		return ram;
	}

	public void setRam(Integer ram) {
		this.ram = ram;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getDrive() {
		return drive;
	}

	public void setDrive(String drive) {
		this.drive = drive;
	}

	public String getDriveType() {
		return driveType;
	}

	public void setDriveType(String driveType) {
		this.driveType = driveType;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public Integer getVideoCard() {
		return videoCard;
	}

	public void setVideoCard(Integer videoCard) {
		this.videoCard = videoCard;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
}