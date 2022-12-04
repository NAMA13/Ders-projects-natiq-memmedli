package az.developia.springmvc;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonController {
	ArrayList<Person> persons_array = new ArrayList<>();


    @PostConstruct
    public void init() {
    	persons_array.add(new Person(1,"Natiq" , 14,"Harasa"));
    	persons_array.add(new Person(2,"Nihad" , 32,"Harasa"));
    	persons_array.add(new Person(3,"Uzeyir" , 90,"Harasa"));
    	persons_array.add(new Person(4,"Mehemmed" , 45,"Harasa"));
    	persons_array.add(new Person(5,"Huseyn" , 60,"Harasa"));
    	persons_array.add(new Person(6,"Eli" , 10,"Harasa"));
    }
    
    @GetMapping
    public String showPage(Model model) {
        model.addAttribute("person_arr", persons_array);
        
		return  "persons";
    }
	

    public String showPage(Model model, @RequestParam(name="q") String s) {
        model.addAttribute("person_arr", persons_array);
        
        ArrayList<Person> filtered = new ArrayList<>();
        
        for(Person st : persons_array) {
        	if(st.getName().toLowerCase().contains(s.toLowerCase())) {
        		filtered.add(st);
        	}
        }
        
		return  "persons";
    }
    
    if(filtered.size()==0) {
		throw new RuntimeException("axtarilan telebe yoxdu");
	}
	
	
    
	@GetMapping(path = "/error")

	public String showError(Model m) {
 
			m.addAttribute("message", "link yoxdu");
			return "my-message";
		 
	}
	
}
