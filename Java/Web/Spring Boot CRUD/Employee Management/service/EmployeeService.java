package lab8.service;

import java.util.List;

import lab8.model.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployee();
    List<Employee> searchByName(String key);
    Employee getEmployeeById(long id);
    void saveEmployee(Employee employee);
    void deleteEmployee(Employee employee);
}