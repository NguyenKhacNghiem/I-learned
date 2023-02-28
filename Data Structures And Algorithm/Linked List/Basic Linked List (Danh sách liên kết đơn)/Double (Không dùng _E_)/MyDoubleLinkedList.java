import java.util.*;

public class MyDoubleLinkedList implements DoubleLinkedListInterface
{
	private DoubleNode head ;
	private int size;
	
	public MyDoubleLinkedList()
	{
		this.head = null ;
		this.size = 0 ;
	}

	public boolean isEmpty() 
    { 
        return (size == 0) ;  
    }

	public int getSize() 
    { 
        return size; 
    }

	public String find(double value) 
    {
		for (DoubleNode i = head ; i != null ; i = i.getPNext())  
			if (i.getValue() == value) 
				return "Find success !";

		return "Find unsucess";
	}

	public void addFirst(double value)  
    {
		head = new DoubleNode(value, head);

		size++ ;  
	}

	public double getFirst() throws NoSuchElementException 
    {
		if(head == null || size == 0 || isEmpty()) throw new NoSuchElementException("Empty Linked List");

        return head.getValue() ;
	}

	public double removeFirst() throws NoSuchElementException 
    {
		if (head == null || size == 0 || isEmpty()) throw new NoSuchElementException("Empty Linked List");
		
		DoubleNode temp ;  

		temp = head ;    
		head = head.getPNext() ;  

		size--;
		return temp.getValue() ;
	}

    public void print() throws NoSuchElementException 
    {
		if (head == null || size == 0 || isEmpty())	throw new NoSuchElementException("Empty Linked List");

		DoubleNode temp = head ;

		System.out.print("List includes: " + temp.getValue()) ; 

		for (int i = 1 ; i < size ;i++)  
        {
			temp = temp.getPNext();
			System.out.print("  " + temp.getValue());
		}

		System.out.println() ;
	}
}

