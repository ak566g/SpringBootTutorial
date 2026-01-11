package com.example.module2.service;

import com.example.module2.configs.MapperConfig;
import com.example.module2.dto.EmployeeDTO;
import com.example.module2.entities.EmployeeEntity;
import com.example.module2.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;


    public boolean isExistByEmployeeId(Long employeeId) {
        return employeeRepository.existsById(employeeId);
    }

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }


    public List<EmployeeDTO> getAllEmployee() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        return employeeEntities.stream().map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class)).toList();
    }

    public Optional<EmployeeDTO> getEmployeeById(long id) {
      return  employeeRepository.findById(id).map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class));
    }

    public EmployeeDTO createNewEmployee(EmployeeEntity inputEmployee) {
        EmployeeEntity employeeEntity = employeeRepository.save(inputEmployee);
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    public EmployeeDTO updateEmployeeById(Long employeeId, EmployeeDTO employeeDTO) {
        boolean exists = isExistByEmployeeId(employeeId);
        if(!exists){
            return null;
        }
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        employeeEntity.setId(employeeId);
        EmployeeEntity savedEmployeeEntity = employeeRepository.save(employeeEntity);
        return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);
    }

    public boolean deleteEmployeeById(Long employeeId) {
        boolean exists = isExistByEmployeeId(employeeId);

        if(!exists)
            return false;

        employeeRepository.deleteById(employeeId);
        return true;
    }

    public EmployeeDTO updatePartialEmployeeById(Long employeeId, Map<String, Object> updates) {
        boolean exists = isExistByEmployeeId(employeeId);
        if(!exists)
            return null;
        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).get();
        updates.forEach((key, value)->{
            Field fieldToBeUpdated =  ReflectionUtils.findFieldIgnoreCase(EmployeeEntity.class, key);
            assert fieldToBeUpdated != null;
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated, employeeEntity, value);
        });
//        employeeRepository.save(employeeEntity);
        return modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDTO.class);
    }
}
