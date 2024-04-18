package com.vunh.service;

import com.vunh.entity.Country;
import com.vunh.entity.Employee;
import com.vunh.repository.CountryRepository;
import com.vunh.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements ServiceCRUD<Employee> {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Employee> getAll() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Page<Employee> getAll(Pageable pageable) {
        return this.employeeRepository.findAll(pageable);
    }

    public List<Country> getAllCountry() {
        return this.countryRepository.findAll();
    }

    public Optional<Employee> getById(int id) {
        return this.employeeRepository.findById(id);
    }

    public void updateFullName(Employee employee) {
        Optional<Employee> optionalEmployee = this.getById(employee.getId());
        if (optionalEmployee.isPresent()) {
            Employee e = optionalEmployee.get();
            e.setFullName(employee.getFullName());
            this.employeeRepository.save(e);
        }
    }

    public void add(Employee employee) {
        this.employeeRepository.save(employee);
    }

    public void delete(int id) {
        this.employeeRepository.delete(this.getById(id).orElse(new Employee()));
    }
}
