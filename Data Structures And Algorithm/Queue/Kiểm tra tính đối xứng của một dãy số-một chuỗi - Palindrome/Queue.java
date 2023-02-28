import java.util.*;

class Queue<E> implements QueueInterface<E> 
{
	private E[] queue;
	private int front; 
    private int back;
	private int size;
	private final int MAXSIZE = 1000;

	public Queue() 
    {
		this.queue = (E[]) new Object[MAXSIZE]; 
		this.front = 0;
		this.back = 0;
		this.size = MAXSIZE;
	}

	public boolean isEmpty() 
    { 
		return (front == back);        
	}

    public E peek()
    { 
		if (isEmpty())  return null;   
            
		return queue[front];
	}

	public E poll() 
    {  
		if (isEmpty()) return null;   

		E temp = queue[front];
		queue[front] = null;
		front = (front + 1) % size;  
		
        return temp;
	}

	public void offer(E value) 
    {  
		if (((back + 1) % size) == front)  
            enlargeQueue();    
				                                 
		queue[back] = value;
		back = (back + 1) % size;   
	}

    private void enlargeQueue() 
    {
		int newSize = size * 2;
		E[] newQueue = (E[]) new Object[newSize];
		
		for (int i=0 ; i < size ; i++) 
			newQueue[i] = queue[(front + i) % size];  
		
		front = 0 ; 
		back = size - 1 ;
		queue = newQueue;
		size = newSize;
	}

    public void print()
    {
        if(isEmpty())
        {
            System.out.println("Queue is empty !") ;  
            return ;
        }

        int temp = front ;  

        while(front != back)
        {
            System.out.println(peek()) ;
            front++ ;
        }

        front = temp ;
    }
}