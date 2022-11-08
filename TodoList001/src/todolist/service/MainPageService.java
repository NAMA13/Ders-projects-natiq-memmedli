package todolist.service;

import java.util.ArrayList;

import todolist.Task;
import todolist.User;
import todolist.repository.*;


public class MainPageService {
	private MainPageRepository MainPageRepository = new MainPageRepository();
	
	public void addCategory(String n) {
		MainPageRepository.addCategory(n);
		
	}

	public void deleteCategory(int id) {
		MainPageRepository.deleteCategory(id);
		
	}
	
	public ArrayList<Task> loadTasks(String p) {
		return MainPageRepository.loadTasks(p);

	}
}
