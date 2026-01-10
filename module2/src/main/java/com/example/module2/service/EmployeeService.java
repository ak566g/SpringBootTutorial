package com.example.module2.service;

import com.example.module2.configs.MapperConfig;
import com.example.module2.dto.EmployeeDTO;
import com.example.module2.entities.EmployeeEntity;
import com.example.module2.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }


    public List<EmployeeDTO> getAllEmployee() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        return employeeEntities.stream().map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class)).toList();
    }

    public EmployeeDTO getEmployeeById(long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElse(null);
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    public EmployeeDTO createNewEmployee(EmployeeEntity inputEmployee) {
        EmployeeEntity employeeEntity = employeeRepository.save(inputEmployee);
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }
}
