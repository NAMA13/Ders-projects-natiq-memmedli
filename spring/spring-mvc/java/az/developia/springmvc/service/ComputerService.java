package az.developia.springmvc.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.springmvc.exceptions.ComputerNotFoundException;
import az.developia.springmvc.model.Computer;
import az.developia.springmvc.repository.ComputerRepository;

@Service
public class ComputerService {

	@Autowired
	private ComputerRepository repository;

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
				throw new ComputerNotFoundException("Axtarilan Computer yoxdu");
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

	public void delete(int id) {
		repository.delete(id);
	}

	public Computer findComputer(int id) {
		return repository.findComputers(id);
	}
}
