import java.util.*;

class Stack <E> implements StackInterface <E> 
{
	private E[] stack;
	private int top;
	private int size;
	private final int MAXSIZE = 1000;

	public Stack() 
    {
		this.stack = (E[]) new Object[MAXSIZE]; 
		this.top = -1;  
		this.size = MAXSIZE;
	}

	public boolean empty() 
    { 
		return (top < 0); 
	}

    public E peek() throws EmptyStackException 
    {
		if (empty())   throw new EmptyStackException();
	
        return stack[top]; 
    }

	public E pop() throws EmptyStackException 
    {
		E temp = peek();
		top--;
        
		return temp;
	}

    public void push(E value) 
    {
		if (top >= size - 1)  enlargeStack(); 
            
        top++;
		stack[top] = value;
	}

	private void enlargeStack() 
    {
		int newSize = 2 * size;  
		E[] newStack = (E[]) new Object[newSize];

		for (int i=0 ; i < size ; i++) 
			newStack[i] = stack[i];
		
		size = newSize;
		stack = newStack;
	}

    public void print() throws EmptyStackException 
    {
        if(empty()) throw new EmptyStackException() ;

        int temp = top ;  
        
        while(top >= 0)
        {
            System.out.println(peek()) ;
            top-- ;
        }
        
        top = temp ;
    }
}