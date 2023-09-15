import javax.persistence.*;
import org.hibernate.Session;
import org.hibernate.Query;
import java.util.*;

public class Main 
{
	static void add()
	{
		Session session = HibernateUtils.getFactory().openSession();
		session.getTransaction().begin();
		
		/* Add to Student table */
		Student student = new Student();
		student.setName("E");
		
		session.save(student);
		
		/* Add to Course table */
		Course course = new Course();
		course.setName("History");
		
		session.save(course);
		
		/* Add to StudentCourse table */
		student = session.get(Student.class, 4);
		course = session.get(Course.class, 4);
		
		StudentCoursePrimaryKey primaryKey = new StudentCoursePrimaryKey();
		primaryKey.setStudent_id(4);
		primaryKey.setCourse_id(4);
		
		StudentCourse studentCourse = new StudentCourse();
		studentCourse.setId(primaryKey);
		studentCourse.setRating(3); /* n-n co thuoc tinh rieng (o day la rating) */
		studentCourse.setStudent(student);
		studentCourse.setCourse(course);
		
		session.save(studentCourse);
		
		session.getTransaction().commit();
		session.close();
	}
	
	static void show()
	{
		Session session = HibernateUtils.getFactory().openSession();
		session.getTransaction().begin();
		
		/* Get courses of a student */
		Student student = session.get(Student.class, 1);
		List<Course> courses = student.getCourses();
		courses.forEach(c -> System.out.println(c.getName()));
		
		/* Get students of a course */
		Course course = session.get(Course.class, 1);
		List<Student> students = course.getStudents();
		students.forEach(s -> System.out.println(s.getName()));
		
		/* n-n co thuoc tinh rieng (o day la rating) */
		/* Get rating score by a student for a course */
		String hql = "FROM StudentCourse WHERE student.id = 1 AND course.id = 1";
		Query query = session.createQuery(hql);

		StudentCourse studentCourse = (StudentCourse) query.uniqueResult();

		System.out.println(studentCourse.getRating());
		
		session.getTransaction().commit();
		session.close();
	}

	public static void main(String[] args) 
	{
		add();
		show();
	}
}
