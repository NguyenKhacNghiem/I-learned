class Node <E>
{
	private E value;
	public Node <E> pNext;

	public Node(E value) 
    { 
        this(value, null) ; 
    }

	public Node(E value, Node <E> next) 
    { 
		this.value = value ;
		this.pNext = next ;   
	}

    public E getValue() 
    { 
        return value; 
    }

	public Node <E> getPNext() 
    { 
        return pNext; 
    }

    public void setValue(E value)
    {
        this.value = value ;
    }

	public void setPNext(Node <E> pNext) 
    { 
        this.pNext = pNext ;
    }
}
