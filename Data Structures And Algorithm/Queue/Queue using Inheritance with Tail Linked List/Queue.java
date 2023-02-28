import java.util.*;

// Queue nay la Queue vong (Circular Array) nham su dung lai nhung vung nho bi lang phi
// Su dung Inheritance
// Cac methods duoc goi thong qua cac methods cua lop cha (Linked List <E>)
class Queue<E> extends LinkedList<E> implements QueueInterface<E> 
{
	public boolean isEmpty() 
    { 
		return super.isEmpty();  // isEmpty() nay la isEmpty cua Linked List nha        
	}

    public E peek()
    { 
		if (isEmpty())  return null;   // su dung ngoai le cung dc 
            
		return getFirst();
	}

	public E poll() 
    {  
		if (isEmpty()) return null;   // su dung ngoai le cung dc 

		E temp = peek();
		removeFirst() ;
        return temp;
	}

	public void offer(E value) 
    {  
		addLast(value) ;
	}

    public void print()
    {
		if(isEmpty())
		{
			System.out.println("Queue is empty !") ;  // dung ngoai le cung dc
			return ;
		}
        super.print() ;  // print() nay la print() cua Tailed Linked List nha
    }
}