package az.developia.springmvc;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
@Service
public class StudentService {
	ArrayList<Student> students = new ArrayList<>();

	@PostConstruct
	private void init() {

		students.add(new Student(1, "Eli", "Ezizli"));
		students.add(new Student(2, "Adil", "Eliyev"));
		students.add(new Student(3, "Huseyn", "Huseynli"));

	}

	public List<Student> filter(String sorgu) {
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
				throw new StudentNotFoundException("axtarilan telebe yoxdu");
			}

		}
		return filtered;
	}
}
