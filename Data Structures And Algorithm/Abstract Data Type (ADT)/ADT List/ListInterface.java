import java.util.* ;

public interface ListInterface <E>   // generic
{
    public boolean isEmpty(); 
	public int size() ;
	public E getFirst() throws NoSuchElementException ;  
	public boolean contains(E item) ;
	public void addFirst(E item) ;
	public void removeFirst() throws NoSuchElementException ; 
	public void print();
}