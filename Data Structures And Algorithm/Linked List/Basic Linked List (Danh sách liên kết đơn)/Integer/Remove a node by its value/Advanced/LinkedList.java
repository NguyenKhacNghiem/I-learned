class LinkedList 
{
    private Node head;

    public LinkedList() 
    {
        head = null;
    }

    // Remove a node by its value
    public void remove(int value)
    {        
        Node current = head, previous = null;

        // remove first case
        if(head != null && head.getValue() == value) 
        {
            head = head.getNext(); 
            return;
        }

        // remove last and middle case
        while(current != null && current.getValue() != value) 
        {
            previous = current;
            current = current.getNext();
        }

        // empty and not found case
        if(current == null)
            return;
 
        previous.setNext(current.getNext());
    }

    public void addFirst(Integer value)
    {
        head = new Node(value, head);
    }

    public void print()
    {
        for(Node i = head;i!=null;i=i.getNext())
            System.out.print(i.getValue() + " ") ;
    }
}