public class LinkedList 
{
    private Node head;

    public LinkedList() 
    {
        head = null;
    }

    public boolean delete(int value) 
    {
        // empty case
        if(head == null)
            return false ;
        
        for(Node i=head;i!=null;i=i.getNext()) 
        {
            // delete first case
            if(i.getValue() == value) 
            {
                head = i.getNext() ;
                i.setNext(null);

                return true ;
            }

            // not found case
            if(i.getNext() == null)
                return false ;

            // delete last and among case
            if(i.getNext().getValue() == value) 
            {
                Node next = new Node(i.getNext().getValue(), i.getNext().getNext()) ;

                (i.getNext()).setNext(null);
                i.setNext(next.getNext());

                return true ;
            }
        }

        return false;
    }
}
