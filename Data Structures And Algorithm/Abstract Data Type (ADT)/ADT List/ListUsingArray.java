import java.util.NoSuchElementException;

public class ListUsingArray <E> implements ListInterface <E>
{
    private static final int MAXSIZE = 1000 ;
	private int num_nodes = 0 ;   // so phan tu cua mang
	private E[] arr = (E[]) new Object[MAXSIZE] ;

    @Override
	public boolean isEmpty() 
    { 
        return num_nodes == 0 ;  // neu so phan tu = 0 thi return true -> mang rong
    }

    @Override
	public int size()        
    { 
        return num_nodes ; 
    }

    @Override
	public E getFirst() throws NoSuchElementException      
    {
		if (num_nodes == 0)    throw new NoSuchElementException("mang rong nen ko co phan tu dau tien") ;
    
		return arr[0];
	}
    // -> danh gia hieu qua: nhanh, vi co mot toan tu return 

    // kiem tra xem mot phan tu co nam trong mang hay khong
    @Override
	public boolean contains(E item) 
    {
		for (int i = 0 ; i < num_nodes ; i++)
			if (arr[i].equals(item)) 
                return true;

		return false;
    }

    // them mot phan tu vao vi tri dau tien
    @Override
    public void addFirst(E item) throws IndexOutOfBoundsException
    {
        if(num_nodes == MAXSIZE)
            throw new IndexOutOfBoundsException("het cho de them") ;

        for(int i = num_nodes - 1 ; i>=0 ; i--)
            arr[i+1] = arr[i] ;
        
        arr[0] = item ;
        num_nodes++ ;
    }
    // -> danh gia hieu qua: cham, vi co n phan tu thi phai dich sang phai n lan

    public void add(int index, E item) throws IndexOutOfBoundsException
    {
        if(num_nodes == MAXSIZE)
            throw new IndexOutOfBoundsException("het cho de them") ;

        for(int i = num_nodes - 1 ; i>=index ; i--)  // 1 2 3 4
            arr[i+1] = arr[i] ;
        
        arr[index] = item ;
        num_nodes++ ;
    }
    // -> danh gia hieu qua: + them vao vi tri cuoi: nhanh, vi ko can dich sang phai + them vao vi tri dau: nhu tren

    // xoa mot phan tu o vi tri dau tien
    @Override
    public void removeFirst() throws NoSuchElementException
    {
        if(num_nodes == 0)
            throw new NoSuchElementException("mang rong nen ko co phan tu dau tien") ;

        for(int i = 0 ; i < num_nodes - 1 ; i++)
            arr[i] = arr[i+1] ;
        
        num_nodes-- ;
    }
    // -> danh gia hieu qua: cham, vi co n phan tu thi phai dich sang trai n lan

    public void remove(int index) throws NoSuchElementException
    {
        if(num_nodes == 0)
            throw new NoSuchElementException("mang rong nen ko co phan tu dau tien") ;

        for(int i = index ; i < num_nodes - 1 ; i++)
            arr[i] = arr[i+1] ;
        
        num_nodes-- ;
    }
    // -> danh gia hieu qua: + xoa vi tri cuoi: nhanh, vi ko can dich sang trai + xoa vi tri dau: nhu tren

    @Override
    public void print() throws NoSuchElementException
    {
        if(num_nodes == 0)
            throw new NoSuchElementException("mang rong") ;

        for(int i=0;i<num_nodes;i++)
            System.out.print(arr[i]+"\t") ;
    }
}