import java.io.* ;

public class MergeSort
{
    public void merge(int a[], int l, int m, int r)
    {
        int i, j, k;
        int n1 = m - l + 1;
        int n2 =  r - m;
     
        // Tao 2 mang tam L, R
        int[] L = new int[n1] ;
        int[] R = new int[n2] ;
     
        for (i = 0; i < n1; i++)
            L[i] = a[l + i];
        for (j = 0; j < n2; j++)
            R[j] = a[m + 1+ j];
     
       
        i = 0; 
        j = 0; 
        k = l; 

        while (i < n1 && j < n2)
        {
            // sap xep tang dan
            if (L[i] <= R[j])  
            {
                a[k] = L[i];
                i++;
            }
            else
            {
                a[k] = R[j];
                j++;
            }

            k++;
        }
     
        // Copy cac phan tu con lai cua mang L vao a 
        while (i < n1)
        {
            a[k] = L[i];
            i++;
            k++;
        }
     
        // Copy cac phan tu con lai cua mang R vao a 
        while (j < n2)
        {
            a[k] = R[j];
            j++;
            k++;
        }
    }

    // l la chi so trai, r la chi so phai cua mang can duoc sap xep
    public void mergeSort(int a[], int l, int r)
    {
        if (l < r)
        {
            int m = l + (r - l)/2;  
 
            // Goi de quy de tiep tuc chia mang
            mergeSort(a, l, m);
            mergeSort(a, m + 1, r);
 
            merge(a, l, m, r);
        }
    }

    public void output(int[] a100, int[] a1000, int[] a10000)
    {
        try
        {
            FileWriter writer100 = new FileWriter("mergeSortOutput100.txt") ;  
            FileWriter writer1000 = new FileWriter("mergeSortOutput1000.txt") ;  
            FileWriter writer10000 = new FileWriter("mergeSortOutput10000.txt") ;  

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