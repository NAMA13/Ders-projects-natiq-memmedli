package az.developia.computershopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import az.developia.computershopping.model.Computer;
import org.springframework.stereotype.Component;


@Component
public class ComputerDAO {
	private DataSource dataSource;

	public ComputerDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Computer> getAllComputers() {
		List<Computer> computers = new ArrayList<>();
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from computers");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Computer computer = new Computer();
				computer.setId(rs.getInt("id"));
				computer.setImage(rs.getString("image"));
				computer.setName(rs.getString("name"));
				computer.setDescription(rs.getString("description"));
				computer.setPrice(rs.getInt("price"));
				computer.setPhone(rs.getString("phone"));
				computer.setNew(rs.getBoolean("is_new"));
				computer.setRam(rs.getInt("ram"));
				computer.setCpu(rs.getString("cpu"));
				computer.setDrive(rs.getString("drive"));
				computer.setDriveType(rs.getString("drive_type"));
				computer.setOs(rs.getString("os"));
				computer.setVideoCard(rs.getInt("video_card"));
				computers.add(computer);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return computers;
	}

	public Computer getComputerById(int id) {
		Computer computer = null;
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from computers where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				computer = new Computer();
				computer.setId(rs.getInt("id"));
				computer.setImage(rs.getString("image"));
				computer.setName(rs.getString("name"));
				computer.setDescription(rs.getString("description"));
				computer.setPrice(rs.getInt("price"));
				computer.setPhone(rs.getString("phone"));
				computer.setNew(rs.getBoolean("is_new"));
				computer.setRam(rs.getInt("ram"));
				computer.setCpu(rs.getString("cpu"));
				computer.setDrive(rs.getString("drive"));
				computer.setDriveType(rs.getString("drive_type"));
				computer.setOs(rs.getString("os"));
				computer.setVideoCard(rs.getInt("video_card"));
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return computer;
	}

	public void addComputer(Computer computer) {
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("insert into computers (name, image, description, price, phone, is_new, ram, cpu, drive, drive_type, os, video_card) values (?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, computer.getName());
			ps.setString(2, computer.getImage());
			ps.setString(3, computer.getDescription());
			ps.setDouble(4, computer.getPrice());
			ps.setString(5, computer.getPhone());
			ps.setBoolean(6, computer.isNew());
			ps.setInt(7, computer.getRam());
			ps.setString(8, computer.getCpu());
			ps.setString(9, computer.getDrive());
			ps.setString(10, computer.getDriveType());
			ps.setString(11, computer.getOs());
			ps.setInt(12, computer.getVideoCard());
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}