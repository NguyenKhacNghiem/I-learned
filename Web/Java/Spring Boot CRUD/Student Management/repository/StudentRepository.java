package lab8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lab8.entity.Student;

// Đây là 1 Repository.
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> { // Student: bảng mà JPA quan tâm
 // Repository này extends JpaRepository nên sẽ sử dụng được các  		  // Long: kiểu dữ liệu của khóa chính
 // hàm có trong thư viện này. Nó sẽ tương tác trên thực thể Student
 // (ánh xạ đến table student) và khóa chính kiểu dữ liệu là Long
}
