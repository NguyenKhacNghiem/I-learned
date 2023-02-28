public class Main
{
    public static void main(String[] args) 
    {
        LinkedList list = new LinkedList();

        // empty case
        Node newNode = new Node(3);    
        list.add(newNode);

        // add first case
        newNode = new Node(1);
        list.add(newNode);

        // add last case
        newNode = new Node(4);
        list.add(newNode);

        // add middle case
        newNode = new Node(2);
        list.add(newNode);

        list.print();
    }
}