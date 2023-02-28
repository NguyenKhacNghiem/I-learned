public class Main
{
    public static void main(String[] args) 
    {
        LinkedList list = new LinkedList();

        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);

        System.out.print("Before: ") ;
        list.print();

        list.remove(5); // remove first case
        list.remove(1); // remove last case
        list.remove(3); // remove middle case
        list.remove(6); // not found case

        System.out.print("\nAfter: ") ;
        list.print();
    }
}