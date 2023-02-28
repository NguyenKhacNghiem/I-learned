import java.io.* ;

public class QuickSort
{
    public int partition(int[] a, int low, int high)
    {
        int pivot = a[high];   
        int left = low;
        int right = high - 1;
        int swap ;

        while(true)
        {
            // sap xep tang dan
            while(left <= right && a[left] < pivot)  
                left++;

            // sap xep tang dan
            while(left <= right && a[right] > pivot) 
                right--;

            if (left >= right) 
                break;

            // hoan vi doi cho
            swap = a[left] ;
            a[left] = a[right] ;
            a[right] = swap ;

            left++;
            right--;
        }

        // hoan vi doi cho
        swap = a[left] ;
        a[left] = a[high] ;
        a[high] = swap ;

        return left;
    }

    public void quickSort(int a[], int low, int high)
    {
        if (low < high)
        {
            int pivot = partition(a, low, high);  // pivot la phan tu trung binh 
                                                  
            // Goi de quy sap xep 2 mang con trai va phai
            quickSort(a, low, pivot - 1);
            quickSort(a, pivot + 1, high);
        }
    }

    public void output(int[] a100, int[] a1000, int[] a10000)
    {
        try
        {
            FileWriter writer100 = new FileWriter("quickSortOutput100.txt") ;  
            FileWriter writer1000 = new FileWriter("quickSortOutput1000.txt") ;  
            FileWriter writer10000 = new FileWriter("quickSortOutput10000.txt") ;  

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