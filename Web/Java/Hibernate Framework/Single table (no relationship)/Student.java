import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="student") // doi lai ten: Student -> student
public class Student implements Serializable 
{ // Dong bo data tren server
	@Id // khoa chinh
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String gender; // giu lai den trong database nen khong can @Column
	private int age;
	private double gpa;
	
	public int getId() 
	{
		return id;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public String getGender() 
	{
		return gender;
	}
	
	public void setGender(String gender) 
	{
		this.gender = gender;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public void setAge(int age) 
	{
		this.age = age;
	}
	
	public double getGpa() 
	{
		return gpa;
	}
	
	public void setGpa(double gpa) 
	{
		this.gpa = gpa;
	}
}
