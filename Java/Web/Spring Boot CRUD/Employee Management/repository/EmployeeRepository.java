package lab8.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import lab8.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Định nghĩa thêm một số custom function bên cạnh các function sẵn có trong JpaRepository
    @Query("select e from Employee e where e.name like %?1%")
	List<Employee> searchByName(String key);
    // -> function trên sẽ tương ứng với câu query bên trên
}