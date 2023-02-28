import java.util.* ;

public interface LinkedListInterface <E>
{
    public boolean isEmpty() ;
    public int getSize() ;
    public boolean contains(E value) ;
    public void addFirst(E value) ;
    public E getFirst() throws NoSuchElementException  ;
    public Node <E> getHead() throws NoSuchElementException  ;
    public E getByIndex(int index) throws NoSuchElementException ;  
    public E removeFirst() throws NoSuchElementException  ;
    public void print() throws NoSuchElementException ;
    public void sort() throws NoSuchElementException ;
}