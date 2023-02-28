import java.util.*;

public class Main
{
	public static void main(String [] args) throws NoSuchElementException 
    {
		LinkedList<Integer> list = new LinkedList<Integer>() ;

		System.out.println("Testing addFirst()") ;
        list.addFirst(1);
		list.addFirst(2);
		list.addFirst(1);
		list.addFirst(2);
		list.addFirst(1);
		list.print(list.getHead());

		System.out.println(list.isSawTooth()) ;

		list.mergeSort(list.getHead()) ;
		list.print(list.getHead());
	}
}


