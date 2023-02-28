import java.nio.file.NoSuchFileException;
import java.util.*;

class LinkedList <E> implements LinkedListInterface <E>
{
	private Node <E> head = null;
	private int size = 0;
	
	public boolean isEmpty() 
    { 
        return (size == 0) ;  
    }

	public int getSize() 
    { 
        return size; 
    }

	public boolean contains(E value) 
    {
		for (Node <E> i = head ; i != null ; i = i.getPNext())  
			if (i.getValue().equals(value)) 
				return true;

		return false;
	}

	public void addFirst(E value)  
    {
		head = new Node<E>(value, head);
		
		size++ ;  
	}

	public E getFirst() throws NoSuchElementException 
    {
		if(head == null || size == 0 || isEmpty()) throw new NoSuchElementException("Empty Linked List");

        return head.getValue() ;
	}

	public Node<E> getHead()
	{
		return head ;
	}

	public E removeFirst() throws NoSuchElementException 
    {
		if (head == null || size == 0 || isEmpty()) throw new NoSuchElementException("Empty Linked List");
		
		Node<E> temp ;  

		temp = head ;    
		head = head.getPNext() ;  

		return temp.getValue() ;
	}

    public void print() throws NoSuchElementException 
    {
		if (head == null || size == 0 || isEmpty())	throw new NoSuchElementException("Empty Linked List");

		Node <E> temp = head ;

		System.out.println("List includes: \n" + temp.getValue()) ;  

		for (int i = 1 ; i < size ;i++)   
        {
			temp = temp.getPNext();
			System.out.println(temp.getValue());
		}

		System.out.println() ;
	}

	public E getByIndex(int index) throws NoSuchElementException
	{
		int k = 0 ;
		
		for (Node <E> i = head ; i != null ; i = i.getPNext(), k++)
			if(k==index)
				return i.getValue() ;

		throw new NoSuchElementException("Not found !") ;
	}

	public void sort() throws NoSuchElementException
	{
		if (head == null || size == 0)	throw new NoSuchElementException("Empty Linked List");

		// Bubble Sort
		Student temp = new Student() ;

		for(int i=0;i<size-1;i++)
			for(int k=0;k<size-1-i;k++)
				if(((Student)getByIndex(k)).getAvg() > ((Student)getByIndex(k+1)).getAvg())
				{
					temp.swapStudent((Student)getByIndex(k)) ;
					((Student)getByIndex(k)).swapStudent((Student)getByIndex(k+1));
					((Student)getByIndex(k+1)).swapStudent(temp) ;
				}
	}
}

