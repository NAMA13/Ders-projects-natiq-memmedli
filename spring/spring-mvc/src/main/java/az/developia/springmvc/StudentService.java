package az.developia.springmvc;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;

	public List<Computer> filter(String sorgu) {
		List<Computer> computers = repository.findAll();
		List<Computer> filtered = new ArrayList<>();
		if (sorgu.trim().equals("")) {

		} else {
			for (Computer st : computers) {
				if (st.getModel().toLowerCase().contains(sorgu.toLowerCase())
						|| st.getBrand().toLowerCase().contains(sorgu.toLowerCase())) {
					filtered.add(st);
				}

			}

			if (filtered.size() == 0) {
				throw new StudentNotFoundException("Axtarilan Computer yoxdu");
			}

		}
		return filtered;
	}

	public List<Computer> findAll() {
		return repository.findAll();

	}

	public void save(Computer s) {
		repository.save(s);
	}

	public void delete(Integer id) {
		repository.delete(id);
	}

	public void edit(Computer c, int id) {
		repository.edit(c, id);
	}

	public Computer findComputer(int id) {
		return repository.findComputers(id);
	}
}
