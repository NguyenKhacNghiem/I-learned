import java.util.*;

class Stack <E> implements StackInterface <E> 
{
    // properties
	private E[] stack;
	private int top;
	private int size;
	private final int MAXSIZE = 1000;

    // constructor
	public Stack() 
    {
		this.stack = (E[]) new Object[MAXSIZE]; 
		this.top = -1;  
		this.size = MAXSIZE;
	}

    // methods
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

    // get more space for stack
	private void enlargeStack() 
    {
		int newSize = 2 * size;  // tuy. Muon tang bao nhieu thi tang. O day la tang gap doi
		E[] newStack = (E[]) new Object[newSize];

        // copy items from old stack to new stack
		for (int i=0 ; i < size ; i++) 
			newStack[i] = stack[i];
		
		size = newSize;
		stack = newStack;
	}

    public void print() throws EmptyStackException 
    {
        if(empty()) throw new EmptyStackException() ;

        int temp = top ;  // temp de giu cai top lai, ko thoi no se -- ben duoi
        
        while(top >= 0)
        {
            System.out.println(peek()) ;
            top-- ;
        }
        
        top = temp ;
    }
}