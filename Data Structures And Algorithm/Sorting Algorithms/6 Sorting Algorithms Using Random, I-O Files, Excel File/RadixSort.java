import java.io.* ;
import java.util.* ;

public class RadixSort
{
    // Lay gia tri lon nhat trong mang
    public int getMax(int a[], int n)
    {
        int max = a[0];
        
        for (int i = 1; i < n; i++)
            if (a[i] > max)
                max = a[i];

        return max;
    }
 
    public void countSort(int a[], int n, int exp)
    {
        int output[] = new int[n]; 
        int count[] = new int[10];  // 10 la cac don vi de so sanh (dv, chuc, tram,...)
        int i;
        Arrays.fill(count, 0);  // them tat ca so 0 vao mang count[]
 
        for (i = 0; i < n; i++)
            count[(a[i] / exp) % 10]++;
 
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
 
        for (i = n - 1; i >= 0; i--) 
        {
            output[count[(a[i] / exp) % 10] - 1] = a[i];
            count[(a[i] / exp) % 10]--;
        }
 
        // Copy output[] vao a[]
        for (i = 0; i < n; i++)
            a[i] = output[i];
    }
    
    // sap xep tang dan
    public void radixSort(int a[], int n)
    {
        // Tim so lon nhat de biet so lon nhat chua bao nhieu chu so
        int max = getMax(a, n);
 
        // Sap xep theo tung chu so o tung hang dv, chuc, tram,...
        for (int exp = 1; max / exp > 0; exp *= 10)
            countSort(a, n, exp);
    }
 
    public void output(int[] a100, int[] a1000, int[] a10000)
    {
        try
        {
            FileWriter writer100 = new FileWriter("radixeSortOutput100.txt") ;  
            FileWriter writer1000 = new FileWriter("radixSortOutput1000.txt") ;  
            FileWriter writer10000 = new FileWriter("radixSortOutput10000.txt") ;  

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