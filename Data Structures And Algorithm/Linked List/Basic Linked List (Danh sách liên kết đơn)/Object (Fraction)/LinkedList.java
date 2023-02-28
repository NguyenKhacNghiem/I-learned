import java.nio.file.NoSuchFileException;
import java.util.*;

class LinkedList <E> implements LinkedListInterface <E>
{
	// properties
	private Node <E> head = null;
	private int size = 0;
	
	// constructor mac dinh se duoc tao tu dong

	public boolean isEmpty() 
    { 
        return (size == 0) ;  // diem moi 
    }

	public int getSize() 
    { 
        return size; 
    }

	public boolean contains(E value) 
    {
		// Cach duyet toan bo Linked List
		for (Node <E> i = head ; i != null ; i = i.getPNext())  // next node = pNext of old node
			if (i.getValue().equals(value)) 
				return true;

		return false;
	}

	public void addFirst(E value)  
    {
		head = new Node<E>(value, head);
		// <=>
 		//Node newNode = new Node (value);
		//newNode.setPNext(head) ; //newNode.pNext = head
		//head = newNode;

		size++ ;  // cap nhat so node cua Linked List
	}

	public void addBefore(Node<E> current, E value)
	{
		Node <E> temp ;

		if(current == head)
		{
			addFirst(value);
			return ;
		}

		for(Node <E> i = head ; i != null ; i = i.getPNext())
		{
			temp = i.getPNext() ;

			if(temp == current)
			{
				addAfter(i, value);
				return ;
			}
		}  
	}

	public void addAfter(Node<E> current, E value)
	{
		if(current == null)
	 		addFirst(value);
		else
		{
		 	Node<E> newNode = new Node<E>(value, current.getPNext());
		 	current.setPNext(newNode);
		}
		size++;
	}

	public void addLast(E value)
	{
		if(head == null)
		 	addFirst(value); 
		else
		{
		 	Node<E> tmp = head;

		 	while(tmp.getPNext() != null)
		 		tmp = tmp.getPNext();
		 	
		 	Node<E> newNode = new Node<E>(value, null);
		 	tmp.setPNext(newNode);
		 	size++;
		}
	}

	public void addByIndex(E value, int index) throws NoSuchElementException 
	{
		if(index < 0 || index > size) throw new NoSuchElementException("index exceeds size") ;
		if(index == 0)	
		{
			addFirst(value) ;
			return ;
		}

		int k = 0 ;
		Node<E> current ;
		
		// Xem mo ta thuat toan ngoi nha 
		for(Node <E> i = head ; i != null ; i = i.getPNext(), k++)  // i vua la pNext, vua la Node
			if(k+1 == index)
			{
				current = i ;
				i = i.getPNext() ;

				i = new Node<E>(value,i) ;
				current.setPNext(i);
			}
		
		size++ ;
	}

	// Lay first node -> lay value cua no
	public E getFirst() throws NoSuchElementException 
    {
		if(head == null || size == 0 || isEmpty()) throw new NoSuchElementException("Empty Linked List");

        return head.getValue() ;
	}

	public Node<E> getHead()
	{
		return head ;
	}

	public E getByIndex(int index) throws NoSuchElementException
	{
		int k = 0 ;
		
		// Xem mo ta thuat toan tai ham contains
		for (Node <E> i = head ; i != null ; i = i.getPNext(), k++)
			if(k==index)
				return i.getValue() ;

		throw new NoSuchElementException("Not found !") ;
	}

	// xoa first node -> xoa value cua no -> nho return lai value xoa dc
	public E removeFirst() throws NoSuchElementException 
    {
		if (head == null || size == 0 || isEmpty()) throw new NoSuchElementException("Empty Linked List");
		
		Node<E> temp ;  // con tro temp dung de giu head

		temp = head ;    // giu head
		head = head.getPNext() ;  // go pNext cua head
		size--;

		return temp.getValue() ;
	}

	public E removeAfter(Node<E> current) throws NoSuchElementException
	{
		if(current == null)	throw new NoSuchElementException("Can't remove element from an empty list");
		else
		{
			Node<E> delNode = current.getPNext();

			if(delNode != null) 
			{
				current.setPNext(delNode.getPNext());
				size--;
				return delNode.getValue();
			}
			else throw new NoSuchElementException("No next node to remove");	
		}
	}

	public E removeLast() throws NoSuchElementException
	{
		if(head == null) throw new NoSuchElementException("Can't remove element from an empty list");
		else
		{
			Node<E> preNode = null;
			Node<E> delNode = head;
			while(delNode.getPNext() != null)
			{
				preNode = delNode;
				delNode = delNode.getPNext();
			}
			preNode.setPNext(delNode.getPNext());
			delNode.setPNext(null);
			size--;
			return delNode.getValue();
		}
	}

	public E removeCurrent(Node<E> current) throws NoSuchElementException
	{
		if(head == null) throw new NoSuchElementException("Can't remove element from an empty list");

		Node<E> temp = head ;

		if(size == 1 || current == head)	return removeFirst() ;

		while(temp.getPNext() != null && temp.getPNext().getValue() != current.getValue())
			temp = temp.getPNext() ;
		
		if(temp.getPNext() != null)  // ra voi dk tim dc current (dk 1, ko phai dk 2)
		{
			removeAfter(temp) ;  
			return temp.getValue() ;
		}

		throw new NoSuchElementException("Remove fail !");
	}

    public E removeByIndex(int index) throws NoSuchElementException
	{
		if(index < 0 || index >= size) 				throw new NoSuchElementException("index exceeds size") ;
		if (head == null || size == 0 || isEmpty()) throw new NoSuchElementException("Empty Linked List");
		if(index == 0)	return removeFirst() ;  

		int k = 0 ;
		Node<E> temp ;
		Node<E> current ;
		Node<E> temp2 ;

		// Xem mo ta thuat toan ngoi nha
		for(Node <E> i = head ; i != null ; i = i.getPNext(), k++)
			if(k+1 == index)
			{
				current = i ;  

				temp = i.getPNext() ;
				temp2 = i.getPNext() ;  

				i = i.getPNext() ;
				i = i.getPNext() ;  

				current.setPNext(i) ;
				temp2.setPNext(null);

				size-- ;
				return temp.getValue() ;

			}

		throw new NoSuchElementException("remove failed") ;
	}

	// Xuat cac node (value cua node) co trong Linked List
    public void print() throws NoSuchElementException 
    {
		if (head == null || size == 0 || isEmpty())	throw new NoSuchElementException("Empty Linked List");

		Node <E> temp = head ;
		// -> phai goi thong qua bien temp vi cac con tro pNext cua cac node da
		// duoc sep ngay ngan trong Linked List roi

		System.out.print("List includes: " + temp.getValue()) ;  // in first node

		for (int i = 1 ; i < size ;i++)   // i = 1 tai in cai first node roi
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

	public void reverse() throws NoSuchElementException 
	{
		if (head == null || size == 0 || isEmpty())	throw new NoSuchElementException("Empty Linked List");

		Node<E> end = null ;
		Node<E> current = null ;

		// lay node end (node cuoi cung trong list) - ko phai node tail nha vi basic ko co tail
		for(Node<E> i = head ; i != null ; i = i.getPNext())
			end = i ;

		while(head != end)
		{
			Node<E> newNode = new Node<E>(head.getValue(),current) ;
			end.setPNext(newNode) ;
			current = newNode ;
			head = head.getPNext() ; // ko dung removeFirst() vi khi do size--
		}

		head = end ;
	}

}

