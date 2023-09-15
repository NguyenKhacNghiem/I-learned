package lab8.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab8.model.Employee;
import lab8.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
    private EmployeeRepository er;
	
    @Override
    public List<Employee> getAllEmployee() {
        return er.findAll();
    }
    
    @Override
    public List<Employee> searchByName(String key) {
        return er.searchByName(key);
    }
    
    @Override
    public Employee getEmployeeById(long id) {
        return er.findById(id).get();
    }
    
    @Override
    public void saveEmployee(Employee employee) {
    	er.save(employee);
    }
    
    @Override
    public void deleteEmployee(Employee employee) {
    	er.delete(employee);
    }
}