import java.util.*;

public class Main
{
	public static void main(String [] args) throws NoSuchElementException 
    {		
		LinkedList <Fraction> list3 = new LinkedList <Fraction>() ;

		System.out.println("Testing addFirst()") ;
        list3.addFirst(new Fraction(1,2));
		list3.addFirst(new Fraction(3,4));
		list3.addFirst(new Fraction(5,6));
		list3.print(); 

		System.out.println("Testing addAfter()") ;
		list3.addAfter(list3.getHead(), new Fraction(7,8)) ;
		list3.print();

		System.out.println("Testing sort()") ;
		list3.sort();
		list3.print();

		System.out.println("Testing removeFirst()") ;
		list3.removeFirst() ;
		list3.print();

		System.out.println("Testing removeAfter()") ;
		list3.removeAfter(list3.getHead()) ;
		list3.print();
	}
}


