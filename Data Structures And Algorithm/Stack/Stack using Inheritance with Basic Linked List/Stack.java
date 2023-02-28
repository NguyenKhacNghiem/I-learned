import java.util.*;

// Su dung Inheritance
// Cac methods duoc goi thong qua cac methods cua lop cha (Linked List <E>)
class Stack <E> extends LinkedList <E> implements StackInterface <E> 
{
	public boolean empty() 
    { 
		return isEmpty(); 
	}

    public E peek() throws EmptyStackException 
    {
		if (empty())   throw new EmptyStackException();
	
        return getFirst(); 
    }

	public E pop() throws EmptyStackException 
    {
		E temp = peek();
		removeFirst();
        
		return temp;
	}

    public void push(E value) 
    {
		addFirst(value);
	}

    public void print() throws EmptyStackException 
    {
        if(empty()) throw new EmptyStackException() ;

        super.print(); // print() nay la print() cua Basic Linked List chu ko phai cua Stack nha
    }
}