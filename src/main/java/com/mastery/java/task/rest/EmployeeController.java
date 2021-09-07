package com.mastery.java.task.rest;


import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/employees",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.ALL_VALUE)
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;


    @PostMapping
    public int addNewEmployee(@RequestBody Employee employee) {
        return employeeService.createNewEmployee(employee);
    }


    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAllEmployees();
    }

    @DeleteMapping("/{employee_id}")
    public void deleteEmployee(@PathVariable("employee_id") int id) {
        employeeService.deleteEmployee(id);
    }

    @PutMapping("/{employee_id}")
    public int updateEmployee(@PathVariable("employee_id") Long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @GetMapping("/{employee_id}")
    public Employee getById(@PathVariable("employee_id") int id) {
        return employeeService.getByEmployeeId(id);
    }
}
