import java.util.*;

public class Main
{
	public static void main(String [] args) throws NoSuchElementException 
    {
        LinkedList <Fraction> list = new LinkedList <Fraction>() ;

		System.out.println("Testing addFirst()") ;
        list.addFirst(new Fraction(1,2));
		list.addFirst(new Fraction(3,4));
		list.print(); 

		System.out.println("Testing addBefore()") ;
		list.addBefore(list.getHead(), new Fraction(5,6));
		list.print();

		System.out.println("Testing addAfter()") ;
		list.addAfter(list.getHead(), new Fraction(5,6));
		list.print(); 

		System.out.println("Testing addLast()") ;
		list.addLast(new Fraction(7,8));
		list.print(); 

		System.out.println("Testing addByIndex()") ;
		list.addByIndex(new Fraction(9,10), 2);
		list.print(); 

		System.out.println("Testing reverse()") ;
		list.reverse();
		list.print();

		System.out.println("Testing sort()") ;
		list.sort();
		list.print();

		System.out.println("Testing removeFirst()") ;
		list.removeFirst() ;
		list.print(); 

		System.out.println("Testing removeAfter()") ;
		list.removeAfter(list.getHead()) ;
		list.print(); 

		System.out.println("Testing removeLast()") ;
		list.removeLast() ;
		list.print(); 

		System.out.println("Testing removeCurrent()") ;
		list.removeCurrent(list.getHead().getPNext()) ;
		list.print(); 

		System.out.println("Testing removeByIndex()") ;
		list.removeByIndex(0) ; 
		list.print() ;  // cho nay xuat ngoai le empty list ne
	}
}


