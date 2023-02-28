class Node <E>
{
	private E value;
	private Node <E> pNext;

	public Node(E value) 
    { 
        this(value, null) ;  
    }

	public Node(E value, Node <E> head) 
    { 
		this.value = value ; 
		this.pNext = head ;   
	}

	public Node <E> getPNext() 
    { 
        return pNext; 
    }

	public E getValue() 
    { 
        return value; 
    }

	public void setPNext(Node <E> pNext) 
    { 
        this.pNext = pNext ;
    }

    public void setValue(E value)
    {
        this.value = value ;
    }
}
