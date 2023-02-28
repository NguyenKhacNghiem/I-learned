import java.util.*;

public class Main
{
	public static void main(String [] args) throws NoSuchElementException 
    {		
		LinkedList <Fraction> list = new LinkedList <Fraction>() ;
		
		System.out.println("Test addFirst()") ;
        list.addFirst(new Fraction(1,2));
		list.addFirst(new Fraction(3,4));
		list.addFirst(new Fraction(5,6));
		list.print(); 

		System.out.println("Test addAfter()") ;
		list.addAfter(list.getHead(), new Fraction(7,8)) ;
		list.print();
		
		System.out.println("Test sort()") ;
		list.sort();
		list.print();

		System.out.println("Test removeFirst()") ;
		list.removeFirst() ;
		list.print();

		System.out.println("Test removeAfter()") ;
		list.removeAfter(list.getHead()) ;
		list.print();
	}
}


