package az.developia.computershopping.controller;

import java.util.List;

import az.developia.computershopping.config.MySession;
import az.developia.computershopping.dao.ComputerDAO;
import az.developia.computershopping.model.Computer;
import az.developia.computershopping.repository.ComputerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/computers")
@CrossOrigin(origins = "*")
public class ComputerRestController {
    @Autowired
    private ComputerDAO computerDAO;

    @Autowired
    private ComputerRepository computerRepository;

    @Autowired
    private MySession mySession;

    @GetMapping
    public List<Computer> loadComputers() {
        return computerDAO.getAllComputers();
    }

    @GetMapping("/modal")
    public List<Computer> loadComputersModal() {
        return computerDAO.getAllComputers();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        computerRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Computer findById(@PathVariable Integer id){
        return computerRepository.findById(id).orElse(null);
    }

    @PutMapping("/edit")
    public void update(@RequestBody Computer computer) {
        computerRepository.save(computer);
    }
    @PostMapping("/save")
    public void save(@RequestBody Computer computer) {
        computerRepository.save(computer);
    }

}