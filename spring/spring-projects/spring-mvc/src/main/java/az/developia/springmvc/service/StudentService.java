package az.developia.springmvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.springmvc.exceptions.StudentNotFoundException;
import az.developia.springmvc.model.Student;
import az.developia.springmvc.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;

	public List<Student> filter(String sorgu) {
		List<Student> students = repository.findAll();
		List<Student> filtered = new ArrayList<>();
		if (sorgu.trim().equals("")) {

		} else {
			for (Student st : students) {
				if (st.getName().toLowerCase().contains(sorgu.toLowerCase())
						|| st.getSurname().toLowerCase().contains(sorgu.toLowerCase())) {
					filtered.add(st);
				}

			}

			if (filtered.size() == 0) {
				throw new StudentNotFoundException("Axtarılan tələbə tapılmadı!!!");
			}

		}
		return filtered;
	}

	public List<Student> findAll() {
		return repository.findAll();

	}

	public void save(Student s) {
		repository.save(s);
	}

	public void delete(Integer id) {
		repository.delete(id);
	}

	public Student findById(Integer id) {
		return repository.findById(id);
	}
}
