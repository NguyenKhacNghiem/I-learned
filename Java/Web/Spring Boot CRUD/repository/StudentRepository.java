package lab8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lab8.entity.Student;

// Đây là 1 Repository.
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> { // Student: bảng mà JPA quan tâm
 // Repository này extends JpaRepository nên sẽ sử dụng được các  		  // Long: kiểu dữ liệu của khóa chính
 // hàm có sẵn trong thư viện này. Nó sẽ tương tác trên thực thể Student
 // (ánh xạ đến table student) và khóa chính kiểu dữ liệu là Long
 
 // Ngoài các hàm được cung cấp sẵn ra, chúng ta có thể tạo thêm các hàm mới và gọi nó để sử dụng. VD:
 @Query("select s from Student s where s.firstName like %?1") // select s: nghĩa là chọn ra toàn bộ thông tin dưới dạng object thay vì các trường
 Student findByFirstName(String firstname);
 
 // Hàm này giống hàm trên nhưng thay vì nhận vào tham số thì tham số sẽ được truyền trên URL (thông qua GET request)
 @Query(value = "select s from Student s where s.firstName = :firstname")
 List<Student> findByFirstName(@Param("firstname") String firstname);
}
