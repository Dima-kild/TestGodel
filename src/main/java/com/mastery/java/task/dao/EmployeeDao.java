package com.mastery.java.task.dao;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.userMapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Employee> getAll() {
        List<Employee> employees = jdbcTemplate.query("select * from employee_db.public.employees",
                new BeanPropertyRowMapper<>(Employee.class));
        return employees;
    }

    public int addNewEmployee(Employee employee) {

        return jdbcTemplate.update("insert into employee_db.public.employees " +
                        "( first_name, last_name, department_id, job_title, gender, date_of_birth) " +
                        "values (?,?,?,?,?,?)", employee.getFirstName(),
                employee.getLastName(), employee.getDepartmentId(), employee.getJobTitle(),
                employee.getGender(), employee.getDateOfBirth());
    }

    public void deleteEmployee(int id) {
        String SQL_DELETE = "delete from employee_db.public.employees where employee_id = ?";
        jdbcTemplate.update(SQL_DELETE, id);

    }

    public int updateEmployee(Long id, Employee employee) {
        String SQL_UPDATE = "update employee_db.public.employees set first_name=?, last_name=?," +
                " department_id=?, job_title=?, gender=?, date_of_birth=?" +
                "where employee_id = ? ";
       return jdbcTemplate.update(SQL_UPDATE,  employee.getFirstName(),
                employee.getLastName(), employee.getDepartmentId(), employee.getJobTitle(),
                employee.getGender(), employee.getDateOfBirth(), id);
    }

    public Employee getById(int id) {
        String SQL_GET_BY_ID = "select * from employee_db.public.employees where  employee_id = ?";
        return jdbcTemplate.queryForObject(SQL_GET_BY_ID, new Mapper(), id);
    }


}
