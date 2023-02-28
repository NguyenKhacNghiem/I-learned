import java.io.* ;

class BubbleSort
{
    public long sort(int[] a)
    {   
        long start = System.currentTimeMillis() ;
        int temp ;

        for(int i=0;i<a.length-1;i++)
            for(int k=0;k<a.length-i-1;k++)
                if(a[k]>a[k+1]) // sx theo thu tu tang dan
                {
                    temp=a[k] ; 
                    a[k] = a[k+1] ; 
                    a[k+1] = temp ; 
                }

        return System.currentTimeMillis() - start ;
    }

    public void output(int[] a100, int[] a1000, int[] a10000)
    {
        try
        {
            FileWriter writer100 = new FileWriter("bubbleSortOutput100.txt") ;  
            FileWriter writer1000 = new FileWriter("bubbleSortOutput1000.txt") ;  
            FileWriter writer10000 = new FileWriter("bubbleSortOutput10000.txt") ;  

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