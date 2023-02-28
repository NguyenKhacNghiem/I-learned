import java.util.*;

// Queue nay la Queue vong (Circular Array) nham su dung lai nhung vung nho bi lang phi
// Su dung Composition
// Cac methods duoc goi thong qua thuoc tinh LinkedList<E> list co chua trong Queue
class Queue<E> implements QueueInterface<E> 
{
    // properties
	private LinkedList<E> list ;

    // constructor
	public Queue() 
    {
		this.list = new LinkedList<E>() ;
	}

    // methods
	public boolean isEmpty() 
    { 
		return list.isEmpty();  // isEmpty() nay la isEmpty cua Linked List nha        
	}

    public E peek()
    { 
		if (isEmpty())  return null;   // su dung ngoai le cung dc 
            
		return list.getFirst();
	}

	public E poll() 
    {  
		if (isEmpty()) return null;   // su dung ngoai le cung dc 

		E temp = peek();
		list.removeFirst() ;
        return temp;
	}

	public void offer(E value) 
    {  
		list.addLast(value) ;
	}

    public void print()
    {
		if(isEmpty())
		{
			System.out.println("Queue is empty !") ;  // dung ngoai le cung dc
			return ;
		}
        list.print() ;  // print() nay la print() cua Tailed Linked List chu ko phai cua Queue nha
    }
}