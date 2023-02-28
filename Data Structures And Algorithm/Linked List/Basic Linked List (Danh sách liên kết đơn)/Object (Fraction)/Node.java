class Node <E>
{
    // properties
	private E value;
	private Node <E> pNext;

    // constructors
	public Node(E value) 
    { 
        this(value, null) ;  // pNext tro toi null 
    }

	public Node(E value, Node <E> head) 
    { 
		this.value = value ; 
		this.pNext = head ;   // pNext of new node = head 
	}

    // getters
	public Node <E> getPNext() 
    { 
        return pNext; 
    }

	public E getValue() 
    { 
        return value; 
    }

    // setters
	public void setPNext(Node <E> pNext) 
    { 
        this.pNext = pNext ;
    }

    public void setValue(E value)
    {
        this.value = value ;
    }
}
