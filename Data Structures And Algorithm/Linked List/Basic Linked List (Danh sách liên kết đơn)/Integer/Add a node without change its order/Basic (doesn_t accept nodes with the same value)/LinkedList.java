public class LinkedList 
{
    private Node head;

    public LinkedList() 
    {
        head = null;
    }

    // doesn't accept nodes with the same value
    public boolean add(Integer value) 
    {
        // empty case
        if(head == null) 
        {
            head = new Node(value, head) ;
            return true ;
        }
        
        // duplicated value case
        for(Node i=head;i!=null;i=i.getNext())
            if(i.getValue() == value)
                return false ;
        
        // add first case
        if(value < head.getValue()) 
        {
            head = new Node(value, head) ;
            return true ;
        }

        for(Node i=head;i!=null;i=i.getNext()) 
        {
            // add last case
            if(i.getNext() == null) 
            {
                Node newNode1 = new Node(value, null) ;
                i.setNext(newNode1);
                return true ;
            }

            // add middle case
            if(value < i.getNext().getValue()) 
            {
                Node newNode2 = new Node(value, i.getNext()) ;
                i.setNext(newNode2);
                return true ;
            }
        }
                    
        return true;
    }

    
