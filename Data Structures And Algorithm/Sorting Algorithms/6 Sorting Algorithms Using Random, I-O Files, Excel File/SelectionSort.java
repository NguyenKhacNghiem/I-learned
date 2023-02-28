import java.io.* ;

public class SelectionSort
{
    public long sort(int[] a)
    {   
        long start = System.currentTimeMillis() ;
        int min_index, temp ;

        for(int i=0;i<a.length-1;i++)
        {
            min_index = i ;

            // tim phan tu nho nhat trong mang
            for(int k=i+1;k<a.length;k++)
                if(a[k]<a[min_index])
                    min_index = k ;
            
            // swap phan tu nho nhat voi phan tu dau tien trong mang
            temp = a[i] ; 
            a[i] = a[min_index] ; 
            a[min_index] = temp ; 
        }

        return System.currentTimeMillis() - start ;
    }

    public void output(int[] a100, int[] a1000, int[] a10000)
    {
        try
        {
            FileWriter writer100 = new FileWriter("selectionSortOutput100.txt") ;  
            FileWriter writer1000 = new FileWriter("selectionSortOutput1000.txt") ;  
            FileWriter writer10000 = new FileWriter("selectionSortOutput10000.txt") ;  

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