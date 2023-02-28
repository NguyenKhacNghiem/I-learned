class LinkedList 
{
    private Node head;

    public LinkedList() 
    {
        head = null;
    }

    // Add a node without change its order
    public void add(Node newNode) 
    {
        Node current;

        // empty and add first case
        if(head == null || head.getValue() >= newNode.getValue()) 
        {
            newNode.setNext(head);
            head = newNode;
        } 
        else // add last and middle case
        {
            current = head;

            while(current.getNext()!= null && current.getNext().getValue() < newNode.getValue())
                current = current.getNext() ;

            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
    }

    public void print()
    {
        for(Node i = head;i!=null;i=i.getNext())
            System.out.print(i.getValue() + " ") ;
    }
}