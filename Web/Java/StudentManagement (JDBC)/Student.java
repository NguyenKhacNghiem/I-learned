public class Student 
{
	private int id;
	private String gender;
	private int age;
	private double gpa;
	
	public Student(int id, String gender, int age, double gpa) 
	{
		this.id = id;
		this.gender = gender;
		this.age = age;
		this.gpa = gpa;
	}
	
	public Student()
	{
		
	}

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
