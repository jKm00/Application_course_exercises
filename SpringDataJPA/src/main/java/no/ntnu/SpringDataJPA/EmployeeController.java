package no.ntnu.SpringDataJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @GetMapping
    public List<Employee> getEmployees() {
        List<Employee> employees = new LinkedList<>();
        Iterable<Employee> dbResult = this.repository.findAll();
        Iterator<Employee> it = dbResult.iterator();
        while (it.hasNext()) {
            employees.add(it.next());
        }
        return employees;
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return this.findEmployeeById(id);
    }

    @PostMapping
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
        ResponseEntity<String> response;
        if (employee.isValid()) {
            this.repository.save(employee);
            response = new ResponseEntity<>(HttpStatus.OK);
        } else {
            response = new ResponseEntity<>("Invalid employee", HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id) {
        ResponseEntity<Employee> response;
        try {
            Employee employee = this.findEmployeeById(id);
            this.repository.deleteById(id);
            response = new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    private Employee findEmployeeById(Long id) {
        Employee employee = null;
        Optional<Employee> result = this.repository.findById(id);
        if (result.isPresent()) {
            employee = result.get();
        }
        return employee;
    }

}
