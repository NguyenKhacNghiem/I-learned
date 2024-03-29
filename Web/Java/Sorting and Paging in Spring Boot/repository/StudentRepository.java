package lab7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lab7.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
}
