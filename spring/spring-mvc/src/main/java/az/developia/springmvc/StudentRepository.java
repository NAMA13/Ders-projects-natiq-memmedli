package az.developia.springmvc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

	@Autowired
	private DataSource dataSource;

	public List<Computer> findAll() {
		List<Computer> computers = new ArrayList<>();
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from computers");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Computer s = new Computer(rs.getInt("id"), rs.getString("model"), rs.getString("brand"),
						rs.getInt("price"));
				computers.add(s);
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return computers;
	}

	public void save(Computer computer) {

		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("insert into computers (model,brand,price) values (?,?,?);");
			ps.setString(1, computer.getModel());
			ps.setString(2, computer.getBrand());
			ps.setInt(3, computer.getPrice());
			ps.executeUpdate();

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void edit(Computer computer, int id) {
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("update computers set model=?,brand=?,price=? where id=" + id + ";");
			ps.setString(1, computer.getModel());
			ps.setString(2, computer.getBrand());
			ps.setInt(3, computer.getPrice());
			ps.executeUpdate();

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Computer findComputers(int id) {
		Computer c = null;
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from computers where id ="+ id +";");

			ResultSet rs = ps.executeQuery();
			
				c = new Computer(rs.getInt("id"), rs.getString("model"), rs.getString("brand"),
						rs.getInt("price"));
			

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	public void delete(Integer id) {

		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("delete from computers  where id=?;");
			ps.setInt(1, id);
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
