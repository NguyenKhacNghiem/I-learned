import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "course")
public class Course implements Serializable {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
 
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	/* n-n co thuoc tinh rieng (o day la rating) */
	public List<StudentCourse> getStudentCourses() {
		return studentCourses;
	}

	public void setStudentCourses(List<StudentCourse> studentCourses) {
		this.studentCourses = studentCourses;
	}

	@ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<Student>();
	
	/* n-n co thuoc tinh rieng (o day la rating) */
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<StudentCourse> studentCourses = new ArrayList<StudentCourse>();
}