package az.developia.computershopping.controller;

import az.developia.computershopping.model.CategoryModel;
import az.developia.computershopping.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/show-admin")
    public String showAdmin(Model model) {
        model.addAttribute("category", new CategoryModel());
        return "admin";
    }


    @PostMapping("/show-admin")
    public String saveOrEditOrDeleteCategory(@ModelAttribute("category") CategoryModel category, @RequestParam(value = "id", required = false) Integer id) {
        if (id == null) { // save request
            categoryRepository.save(category);
            return "redirect:/show-admin?id=" + category.getId(); // redirect to category edit page
        } else { // edit request
            CategoryModel existingCategory = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
            categoryRepository.deleteById(category.getId());
            existingCategory.setName(category.getName());
            categoryRepository.save(existingCategory);
            return "redirect:/show-admin?id=" + existingCategory.getId(); // redirect to category edit page
     }
    }



    @RequestMapping("/show-admin/{id}")
    public String selectedCategory(@PathVariable Integer id) {
        System.out.println("selectedCategory called with id=" + id);
        return "admin";
    }


}
