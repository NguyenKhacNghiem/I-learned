import java.util.* ;

public interface LinkedListInterface <E>
{
    // Interface la noi chua nhung methods cua Linked List
    // Nhung methods tuong tac tren mot node tuc la tuong tac tren value cua node do.
    // Khong quan tam den pNext.
    public boolean isEmpty() ;
    public int getSize() ;
    public boolean contains(E value) ;
    public void addFirst(E value) ;
    public void addBefore(Node<E> current, E value) ;
    public void addAfter(Node <E> current, E value) ;
    public void addLast(E value) ;
    public void addByIndex(E value, int index) throws NoSuchElementException ; // index starts at 0
    public E getFirst() throws NoSuchElementException  ;
    public Node <E> getHead() throws NoSuchElementException  ;
    public E getByIndex(int index) throws NoSuchElementException ;  // index starts at 0
    public E removeFirst() throws NoSuchElementException  ;
    public E removeAfter(Node <E> current) throws NoSuchElementException ; 
    public E removeLast() throws NoSuchElementException  ;
    public E removeCurrent(Node<E> current) ;
    public E removeByIndex(int index) throws NoSuchElementException  ;  // index starts at 0
    public void print() throws NoSuchElementException ;
    public void sort() throws NoSuchElementException ;
    public void reverse() throws NoSuchElementException ;  // list nguoc
}