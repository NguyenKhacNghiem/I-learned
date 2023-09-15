import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "studentcourse")
public class StudentCourse implements Serializable {
	@EmbeddedId
	private StudentCoursePrimaryKey id;
	
    @JoinColumn(name = "student_id")
    @MapsId("student_id")
    @ManyToOne
    private Student student;
    
    @JoinColumn(name = "course_id")
    @MapsId("course_id")
    @ManyToOne
    private Course course;
    
    /* n-n co thuoc tinh rieng (o day la rating) */
    private int rating;
    
	public StudentCoursePrimaryKey getId() {
		return id;
	}

	public void setId(StudentCoursePrimaryKey id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	/* n-n co thuoc tinh rieng (o day la rating) */
	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}