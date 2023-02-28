import java.util.*;

class LinkedList <E> implements LinkedListInterface <E>
{
	private Node <E> head = null;
	private Node <E> tail = null;
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
		for (Node<E> i = head ; i != null ; i = i.getPNext())  
			if (i.getValue().equals(value)) 
				return true;

		return false;
	}

	public E getFirst() throws NoSuchElementException 
    {
		if(head == null || size == 0 || isEmpty()) 
			throw new NoSuchElementException("Empty Linked List");

        return head.getValue() ;
	}

	public Node<E> getHead()
	{
		return head ;
	}

	public Node<E> getTail()
	{
		return tail ;
	}

	// used for sort method
	public E getByIndex(int index) throws NoSuchElementException  
	{
		int k = 0 ;
		
		for (Node <E> i = head ; i != null ; i = i.getPNext(), k++)
			if(k==index)
				return i.getValue() ;

		throw new NoSuchElementException("Not found !") ;
	}

	public void addFirst(E value)  
    {
		if(size == 0)	
		{
			head = new Node<E>(value, head);
			tail = head ;
		}
		else
			head = new Node<E>(value, head);
		
		size++ ;  
	}
	
	public void addAfter(Node<E> current, E value)
	{
		if(current == tail)
		{
			Node<E> newNode = new Node<E>(value) ;

			tail.setPNext(newNode) ;
			tail = newNode ;
		}
		else
		{
			Node<E> newNode = new Node<E>(value, current.getPNext()) ;		

			current.setPNext(newNode);
		}

		size++ ;
	}
	
	public E removeFirst() throws NoSuchElementException 
    {
		if (head == null || size == 0 || isEmpty()) throw new NoSuchElementException("Empty Linked List");
		
		if(head == tail)
		{
			E temp = head.getValue() ;
			head = null ;
			tail = null ;
			size-- ;
			return temp ;
		}

		Node<E> temp = head ;    

		head = head.getPNext() ;

		size--;
		return temp.getValue() ;
	}
	
	public E removeAfter(Node<E> current)  throws NoSuchElementException
	{
		if (head == null || size == 0 || isEmpty()) 
			throw new NoSuchElementException("Empty Linked List");

		if(head == tail || current == tail)
			throw new NoSuchElementException("No next node to remove") ;

		Node<E> temp = current.getPNext() ;
		current.setPNext(current.getPNext().getPNext());
		
		size-- ;
		return temp.getValue() ;
	}

    public void print() throws NoSuchElementException 
    {
		if (head == null || size == 0 || isEmpty())	throw new NoSuchElementException("Empty Linked List");

		Node <E> temp = head ;

		System.out.print("List includes: " + temp.getValue()) ;  

		for (int i = 1 ; i < size ;i++)   
        {
			temp = temp.getPNext();
			System.out.print("  " + temp.getValue());
		}

		System.out.println() ;
	}

	public void sort() throws NoSuchElementException
	{
		if (head == null || size == 0 || isEmpty())	throw new NoSuchElementException("Empty Linked List");

		// Bubble Sort
		for(int i=0;i<size-1;i++)   
		{
			Node<E> n1 = head ;
			Node<E> n2 = head.getPNext() ;
			
			for(int k=0;k<size-1-i;k++)
			{
				if(((Fraction)n1.getValue()).getFractionValue() > ((Fraction)n2.getValue()).getFractionValue())  // giam dan: <
		 		{
					// swap 2 node thuc chat la swap 2 cai value cua no, con tro pNext giu nguyen
		 			E temp = n1.getValue() ;
		 			n1.setValue(n2.getValue());
		 			n2.setValue(temp);
		 		}

				n1 = n2 ;
				n2 = n2.getPNext() ;
			}
		}
	}
}

