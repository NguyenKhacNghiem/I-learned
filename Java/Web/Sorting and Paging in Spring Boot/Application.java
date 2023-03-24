package lab7;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lab7.model.Student;
import lab7.service.StudentService;

@SpringBootApplication
public class Application implements CommandLineRunner { // implements CommandLineRunner: Spring Boot sẽ
 	@Autowired 											// chạy ở màn hình console thay vì chạy trên Web
	StudentService ss;
	
	public static void printStudent(List<Student> students) {
		for(Student s : students)
			System.out.println(s);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Add 12 students
		ss.addStudent(new Student(1, "Peter", 20, "peter@gmail.com", 6.5));
		ss.addStudent(new Student(2, "David", 20, "david@gmail.com", 6.7));
		ss.addStudent(new Student(3, "Hana", 20, "hana@gmail.com", 6.7));
		ss.addStudent(new Student(4, "John", 20, "john@gmail.com", 6.8));
		ss.addStudent(new Student(5, "Cowsep", 20, "cowsep@gmail.com", 6.7));
		ss.addStudent(new Student(6, "Nicolas", 20, "nicolas@gmail.com", 7.1));
		ss.addStudent(new Student(7, "Anna", 26, "anna@gmail.com", 7.2));
		ss.addStudent(new Student(8, "Johny", 27, "johny@gmail.com", 7.3));
		ss.addStudent(new Student(9, "Mike", 31, "mike@gmail.com", 7.4));
		ss.addStudent(new Student(10, "Jessica", 31, "jessica@gmail.com", 7.5));
		ss.addStudent(new Student(11, "Alice", 31, "alice@gmail.com", 7.6));
		ss.addStudent(new Student(12, "Nick", 31, "nick@gmail.com", 7.7));
		
		// Sort the above list
		System.out.println("The sorted list: ");
		printStudent(ss.getSortedStudents());
		
		// Paging (get student at index 4, 5, 6)
		System.out.println("The paging list: ");
		printStudent(ss.getPagingStudents());
	}
}
