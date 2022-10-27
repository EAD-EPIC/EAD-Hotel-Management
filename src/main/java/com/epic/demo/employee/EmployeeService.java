package com.epic.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository studentRepository) {
        this.employeeRepository = studentRepository;
    }

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public void addEmployee(Employee employee) {
        Optional<Employee> employeeOptional = employeeRepository.findEmployeeByEmail(employee.getEmail());

        if(employeeOptional.isPresent()){
            throw new IllegalStateException("Email already exist");
        }
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long employeeId) {
        boolean exist = employeeRepository.existsById(employeeId);
        if(!exist){
            throw new IllegalStateException("Student with id "+employeeId+" does nt exist");
        }
        employeeRepository.deleteById(employeeId);
    }

    @Transactional
    public void updateEmployee(Long employeeId, String firstName, String lastName, String address,String email) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new IllegalStateException(
                        "Student with id "+employeeId+" does nt exist"
                ));

        if (firstName != null &&
                firstName.length()>0 &&
                !Objects.equals(employee.getFirstName(),firstName)){
            employee.setFirstName(firstName);
        }

        if (lastName != null &&
                lastName.length()>0 &&
                !Objects.equals(employee.getLastName(),lastName)){
            employee.setLastName(lastName);
        }
        if (address != null &&
                address.length()>0 &&
                !Objects.equals(employee.getAddress(),address)){
            employee.setAddress(address);
        }

        if (email != null &&
                email.length()>0 &&
                !Objects.equals(employee.getEmail(),email)){
            Optional<Employee> employeeOptional = employeeRepository.findEmployeeByEmail(email);
            if (employeeOptional.isPresent()){
                throw new IllegalStateException("Email taken");
            }
            employee.setEmail(email);
        }
    }
}
