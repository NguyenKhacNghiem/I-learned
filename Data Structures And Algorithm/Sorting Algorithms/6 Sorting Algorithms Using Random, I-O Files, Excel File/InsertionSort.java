import java.io.* ; 

public class InsertionSort
{
    public long sort(int[] a)
    {   
        long start = System.currentTimeMillis() ;
        int j ;
        
        for (int i = 1 ; i < a.length ; i++) 
        { 
            int next = a[i];    

            // sap xep tang dan
            for (j = i - 1; j>=0 && a[j] > next ; j--)  
                a[j+1] = a[j];
    
            a[j+1] = next;  
        }

        return System.currentTimeMillis() - start ;
    }

    public void output(int[] a100, int[] a1000, int[] a10000)
    {
        try
        {
            FileWriter writer100 = new FileWriter("insertionSortOutput100.txt") ;  
            FileWriter writer1000 = new FileWriter("insertionSortOutput1000.txt") ;  
            FileWriter writer10000 = new FileWriter("insertionSortOutput10000.txt") ;  

            for(int i=0;i<100;i++)   writer100.write(a100[i] + "\n") ;
            for(int i=0;i<1000;i++)  writer1000.write(a1000[i] + "\n") ;            
            for(int i=0;i<10000;i++) writer10000.write(a10000[i] + "\n") ;
            
            writer100.close() ;
            writer1000.close();
            writer10000.close();

        }catch(Exception e){
            System.out.println("Error when writing file !!") ; 
        }
    }
}