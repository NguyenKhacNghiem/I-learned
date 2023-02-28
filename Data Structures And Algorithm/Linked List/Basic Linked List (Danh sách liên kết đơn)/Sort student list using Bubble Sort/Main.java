import java.util.*;

public class Main
{
	public static void main(String [] args) throws NoSuchElementException 
    {
        LinkedList<Student> list = new LinkedList<Student>() ;

		System.out.println("Testing addFirst()") ;
		list.addFirst(new Student("S1", 1, 2, 3));
		list.addFirst(new Student("S2", 4, 5, 6));
        list.addFirst(new Student("S3", 7, 8, 9));
		list.print(); 

		System.out.println("Testing sort()") ;
		list.sort();
		list.print();
	}
}


