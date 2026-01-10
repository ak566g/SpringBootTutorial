package com.example.module2.controllers;

import com.example.module2.dto.EmployeeDTO;
import com.example.module2.entities.EmployeeEntity;
import com.example.module2.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
    public final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping(path = "/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable(name="employeeId") long id){
        return employeeRepository.findById(id).orElse(null);
    }

    @GetMapping
    public List<EmployeeEntity> getAllEmployee(){
        return employeeRepository.findAll();
    }

    @PostMapping EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity inputEmployee){
        return employeeRepository.save(inputEmployee);
    }

    @PutMapping String updateEmployeeId(){
        return "Hello from Put";
    }
}
