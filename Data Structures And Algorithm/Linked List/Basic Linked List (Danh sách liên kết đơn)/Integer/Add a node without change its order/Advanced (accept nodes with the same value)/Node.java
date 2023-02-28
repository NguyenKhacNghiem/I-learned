class Node
{
    // properties
	private Integer value;
	private Node next;

    // constructors
	public Node(Integer value) 
    { 
        this(value, null) ; 
    }

	public Node(Integer value, Node next) 
    { 
		this.value = value ; 
		this.next = next ;   
	}

    // getters
	public Node getNext() 
    { 
        return next; 
    }

	public Integer getValue() 
    { 
        return value; 
    }

    // setters
	public void setNext(Node next) 
    { 
        this.next = next ;
    }

    public void setValue(Integer value)
    {
        this.value = value ;
    }
}