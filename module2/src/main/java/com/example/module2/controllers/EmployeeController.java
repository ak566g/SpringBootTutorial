package com.example.module2.controllers;

import com.example.module2.dto.EmployeeDTO;
import com.example.module2.entities.EmployeeEntity;
import com.example.module2.repository.EmployeeRepository;
import com.example.module2.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController( EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name="employeeId") long id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @PostMapping EmployeeDTO createNewEmployee(@RequestBody EmployeeEntity inputEmployee){
        return employeeService.createNewEmployee(inputEmployee);
    }

    @PutMapping String updateEmployeeId(){
        return "Hello from Put";
    }
}
