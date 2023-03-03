import java.util.*;
import java.io.*;

public class Main 
{	
	static void writeFile(ArrayList<Student> students)
	{
		try
        {
            FileOutputStream file = new FileOutputStream("students.dat");
            ObjectOutputStream out = new ObjectOutputStream(file);
            
            for(Student s : students) 
			{
            	out.writeObject(s);
            	out.writeChars("\n");
            }
            
            out.close();
            file.close();            
        }catch(Exception e)
		{
        	System.out.println("Error: " + e.getMessage());
        }
	}
	
	static void readFile() 
	{
		try {
			ArrayList<Student> students = new ArrayList<>();
            FileInputStream file = new FileInputStream("students.dat");
            ObjectInputStream in = new ObjectInputStream(file);
            
            while (file.available() > 0) 
			{
                Student s = (Student) in.readObject();
                in.readChar();  // read "\n"
				
				students.add(s);
            }
            
            in.close();
            file.close();
			
			for(Student i : students)
				System.out.println(i);
        } 
		catch(Exception e) 
		{
            System.out.println("Error: " + e.getMessage());
        } 
	}
	
	public static void main(String[] args) 
	{
		ArrayList<Student> students = new ArrayList<>();
		
		students.add(new Student(1, "Peter", 18));
		students.add(new Student(2, "Anna", 19));
		students.add(new Student(3, "David", 20));
		
		// Write file
		writeFile(students);
		
		// Read file
		readFile();
	}
}
