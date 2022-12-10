package az.developia.springmvc;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
public class BookService {

	ArrayList<Book> books = new ArrayList<>();

	@PostConstruct
	private void init() {

		books.add(new Book(1, "Ikinci addim", 55));
		books.add(new Book(2, "Melek ve Şeytan", 55));
		books.add(new Book(3, "Nə bilim", 55));

	}

	public List<Book> filter(String sorgu) {
		List<Book> filtered = new ArrayList<>();
		if (sorgu.trim().equals("")) {

		} else {
			for (Book st : books) {
				if (st.getName().toLowerCase().contains(sorgu.toLowerCase())
						|| st.getName().toLowerCase().contains(sorgu.toLowerCase())) {
					filtered.add(st);
				}

			}

			if (filtered.size() == 0) {
				throw new StudentNotFoundException("Axtarilan Kitab yoxdu");
			}

		}
		return filtered;
	}

}
