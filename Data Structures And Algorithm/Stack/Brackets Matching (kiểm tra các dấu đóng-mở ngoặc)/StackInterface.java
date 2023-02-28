import java.util.*;

public interface StackInterface <E> 
{
	public boolean empty(); 
	public E peek() throws EmptyStackException;  
	public E pop() throws EmptyStackException;   
	public void push(E value);                   
    public void print() throws EmptyStackException ;
}
