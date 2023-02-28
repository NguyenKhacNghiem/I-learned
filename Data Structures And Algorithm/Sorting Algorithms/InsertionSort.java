// Insertion Sort la giai thuat lay cam hung tu tro choi danh bai, rut bai len va sap xep

public class InsertionSort
{
    static void print(int[] a)
    {
        for(int i:a)
            System.out.print(i + " ") ;

        System.out.println() ;
    }
    public static void main(String[] args) 
    {
        int[] a = new int[]{5,4,6,8,2,1,10} ;
        int j ;
        System.out.print("Mang da cho: ") ;
        print(a);
        
        for (int i = 1 ; i < a.length ; i++) 
        { 
            int next = a[i];    

            // sap xep tang dan
            for (j = i - 1; j>=0 && a[j] > next ; j--)  // giam dan: a[j] < next
                a[j+1] = a[j];
    
            a[j+1] = next;  
        }

        System.out.print("Mang sau khi sap xep: ") ;
        print(a);
    }
}