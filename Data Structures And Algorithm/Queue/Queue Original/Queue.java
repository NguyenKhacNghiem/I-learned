import java.util.*;

// Queue nay la Queue vong (Circular Array) nham su dung lai nhung vung nho bi lang phi
class Queue<E> implements QueueInterface<E> 
{
    // properties
	private E[] queue;
	private int front; 
    private int back;
	private int size;
	private final int MAXSIZE = 1000;

    // constructor
	public Queue() 
    {
		this.queue = (E[]) new Object[MAXSIZE]; 
		this.front = 0;
		this.back = 0;
		this.size = MAXSIZE;
	}

    // methods
	public boolean isEmpty() 
    { 
		return (front == back);        
	}

    public E peek()
    { 
		if (isEmpty())  return null;   // su dung ngoai le cung dc 
            
		return queue[front];
	}

	public E poll() 
    {  
		if (isEmpty()) return null;   // su dung ngoai le cung dc 

		E temp = queue[front];
		queue[front] = null;
		front = (front + 1) % size;  // *cong thuc: tinh lai gia tri cua front khi phan tu tren cung bi xoa
		
        return temp;
	}

	public void offer(E value) 
    {  
		if (((back + 1) % size) == front)  // Queue is full (do su dung Queue vong)
            enlargeQueue();    
				                                 
		queue[back] = value;
		back = (back + 1) % size;   // *cong thuc: tinh lai gia tri cua back khi them moi mot phan tu vao sau cung
	}

    // get more space for Queue
    private void enlargeQueue() 
    {
		int newSize = size * 2;
		E[] newQueue = (E[]) new Object[newSize];
		
		for (int i=0 ; i < size ; i++) 
			newQueue[i] = queue[(front + i) % size];  // *cong thuc: copy cac phan tu o queue cu qua queue moi
		
		front = 0 ; 
		back = size - 1 ;
		queue = newQueue;
		size = newSize;
	}

    public void print()
    {
        if(isEmpty())
        {
            System.out.println("Queue is empty !") ;  // dung ngoai le cung dc
            return ;
        }

        int temp = front ;  // temp de giu cai front lai, ko thoi no se ++ ben duoi

        while(front != back)
        {
            System.out.println(peek()) ;
            front++ ;
        }

        front = temp ;
    }
}