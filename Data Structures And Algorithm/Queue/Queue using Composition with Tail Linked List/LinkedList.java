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

	public void addLast(E value)
	{
		if(size == 0 || head == null)	addFirst(value) ;
		else
		{
			Node<E> newNode = new Node<E>(value) ;
			tail.setPNext(newNode) ;
			tail = newNode ;
			size++ ; 
		}
	}
	
	public void addAfter(Node<E> current, E value)
	{
		if(current == tail)
			addLast(value) ;
		else
		{
			Node<E> newNode = new Node<E>(value, current.getPNext()) ;		

			current.setPNext(newNode);
			size++ ;
		}
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
}

