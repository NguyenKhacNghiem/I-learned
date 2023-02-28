import java.util.*;

class LinkedList<E> implements LinkedListInterface<E>
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

	public Node <E> getByIndex(int index) throws NoSuchElementException
	{
		int k = 0 ;
		
		for (Node <E> i = head ; i != null ; i = i.getPNext(), k++)
			if(k==index)
				return i ;

		throw new NoSuchElementException("Not found !") ;
	}

	// xoa first node -> xoa value cua no -> nho return lai value xoa dc
	public E removeFirst() throws NoSuchElementException 
    {
		if (head == null || size == 0 || isEmpty()) throw new NoSuchElementException("Empty Linked List");
		
		Node<E> temp ;  

		temp = head ;    
		head = head.getPNext() ;  

		size--;
		return temp.getValue() ;
	}

	public E removeAfter(Node<E> curr) throws NoSuchElementException
	{
		if(curr == null)	throw new NoSuchElementException("Can't remove element from an empty list");
		else
		{
			Node<E> delNode = curr.getPNext();

			if(delNode != null) 
			{
				curr.setPNext(delNode.getPNext());
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
    public void print(Node<E> head)
    {
		
		//if (head == null || size == 0 || isEmpty())	throw new NoSuchElementException("Empty Linked List");
		/*
		Node <E> temp = head ;

		System.out.print("List includes: " + temp.getValue()) ;  // print first node

		for (int i = 1 ; i < size ;i++)   // i = 1 tai print cai first node roi
        {
			temp = temp.getPNext();
			System.out.print("  " + temp.getValue());
		}

		System.out.println() ;
		*/

		// dung de quy cho nhanh
		if(head != null)
		{
			System.out.println(head.getValue()) ;  
			print(head.getPNext()) ;  // dua dong nay len tren thi in theo chieu nguoc lai (reverse)
		}
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
				if((Integer)n1.getValue() > (Integer)n2.getValue())  // giam dan: <
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

		// lay node end (node cuoi cung trong list) - ko phai tail vi basic ko co tail
		for(Node<E> i = head ; i != null ; i = i.getPNext())
			end = i ;

		while(head != end)
		{
			Node<E> newNode = new Node<E>(head.getValue(),current) ;
			end.setPNext(newNode) ;
			current = newNode ;
			head = head.getPNext() ;  // ko removeFirst() vi khi do size--
		}

		head = end ;
	}

	public int countEven()
	{
		int count = 0 ;

		for(Node <E> i = head ; i != null ; i = i.getPNext())  
			if((Integer)i.getValue() % 2 == 0)
				count++ ;
		
		return count ;
	}

	public boolean isPrime(Integer n)
	{
		if(n<2)	return false ;

		for(int i=2;i<=Math.sqrt(n);i++)
			if(n%i==0)
				return false ;
		
		return true ;
	}
    
	public int countPrime()
	{
		int count = 0 ;

		for(Node <E> i = head ; i != null ; i = i.getPNext())  
			if(isPrime((Integer)i.getValue()))
				count++ ;
		
		return count ;
	}

    public E findMax()
	{
		E max ;

		max = head.getValue() ;

		for(Node <E> i = head ; i != null ; i = i.getPNext())  
			if((Integer)i.getValue() > (Integer) max)
				max = i.getValue() ;

		return max ;
	}

	// kiem tra mot list co phai la rang cua hay khong ?
	// rang cua duoc hieu la gia tri tang roi giam tang roi giam hoac nguoc lai
	public boolean isSawTooth() throws NoSuchElementException 
	{
		if (head == null || size == 0 || isEmpty())	
			throw new NoSuchElementException("Empty Linked List");
		
		// 1 phan tu thi khong phai rang cua
		if(size == 1)	
			return false ;

		boolean isUp ;

		for(Node<E> i = head ; i != null ; i = i.getPNext())
		{
			Node<E> temp = i.getPNext() ;

			if(temp == null)
				return true ;

			if((Integer)temp.getValue() > (Integer)i.getValue())		isUp = true ;		
			else if((Integer)temp.getValue() < (Integer)i.getValue())	isUp = false ;
			else														return false ;

			if(isUp && (Integer)temp.getValue() < (Integer)i.getValue())
				return false ;

			if(!isUp && (Integer)temp.getValue() > (Integer)i.getValue())
				return false ;
		}

		return true ;
	}

	// Merge Sort in Linked List
	public Node <E> mergeSort(Node<E> head) 
	{
        if(head == null || head.getPNext() == null) 
            return head;
 
        Node<E> mid = getMiddleNode(head);
        Node<E> afterMid = mid.getPNext();
 
        mid.setPNext(null); 
 
        Node<E> left = mergeSort(head);
        Node<E> right = mergeSort(afterMid);

        return mergeTwoLists(left, right) ;
    }

	private Node<E> mergeTwoLists(Node<E> n1, Node<E> n2) 
	{
        Node<E> node = null;
		Node<E> temp ;

        if(n1 == null)
            return n2;

        if(n2 == null)
            return n1;
		
		// ascending order
        if ((Integer)n1.getValue() <= (Integer)n2.getValue()) 
		{
            node = n1;
			temp = mergeTwoLists(n1.getPNext(), n2) ;
            node.setPNext(temp);
        }
        else 
		{
            node = n2;
			temp = mergeTwoLists(n1, n2.getPNext()) ;
            node.setPNext(temp);
        }

        return node;
    }

	private Node<E> getMiddleNode(Node<E> head) 
	{
        if(head == null)
            return head;
 
		Node<E> n1 = head; 
		Node<E> n2 = head;
 
        while (n2.getPNext() != null && n2.getPNext().getPNext() != null) 
		{
            n1 = n1.getPNext();
            n2 = n2.getPNext().getPNext();
        }
		
        return n1;
    }
}

