import java.util.*;

// Su dung Composition
// Cac methods duoc goi thong qua thuoc tinh LinkedList<E> list co chua trong Stack
class Stack <E> implements StackInterface <E> 
{
    // properties
	private LinkedList<E> list ;

    // constructor
	public Stack() 
    {
		this.list = new LinkedList<E>() ;
	}

    // methods
	public boolean empty() 
    { 
		return list.isEmpty(); 
	}

    public E peek() throws EmptyStackException 
    {
		if (empty())   throw new EmptyStackException();
	
        return list.getFirst(); 
    }

	public E pop() throws EmptyStackException 
    {
		E temp = peek();
		list.removeFirst();
        
		return temp;
	}

    public void push(E value) 
    {
		list.addFirst(value);
	}

    public void print() throws EmptyStackException 
    {
        if(empty()) throw new EmptyStackException() ;

        list.print(); // print() nay la print() cua Basic Linked List chu ko phai cua Stack nha
    }
}