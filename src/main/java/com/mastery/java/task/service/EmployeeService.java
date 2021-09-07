package com.mastery.java.task.service;

import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.dto.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EmployeeService {

    final private EmployeeDao employeeDao;

    public int createNewEmployee(Employee employee){
        return employeeDao.addNewEmployee(employee);
    }

    public void deleteEmployee(int id){
        employeeDao.deleteEmployee(id);
    }

    public Employee getByEmployeeId(int id){
        return employeeDao.getById(id);

    }

    public List<Employee> getAllEmployees(){
        return employeeDao.getAll();
    }

    public int updateEmployee(Long id, Employee employee){
        return employeeDao.updateEmployee(id, employee);

    }
}
