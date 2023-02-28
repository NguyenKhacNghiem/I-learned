// Sap xep doi cho truc tiep
public class InterchangeSort
{
    static void interchangeSort(int[] a)
    {
        for(int i=0;i<a.length-1;i++)
            for(int k=i+1;k<a.length;k++)
                if(a[k] < a[i])   // tang dan, giam dan -> >
                {
                    int temp = a[k] ;
                    a[k] = a[i] ;
                    a[i] = temp ;
                }
    }

    static void print(int[] a)
    {
        for(int i:a)
            System.out.print(i + "\t") ;
        
        System.out.println() ;
    }

    public static void main(String[] args) 
    {
        int[] a = new int[]{1, 3, 2, 5, 4, 6} ;
        
        System.out.println("Before sorting") ;
        print(a) ;

        System.out.println("After sorting") ;
        interchangeSort(a);
        print(a) ;
    }
}