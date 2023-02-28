public class QuickSort
{
    static int partition(int[] a, int low, int high)
    {
        int pivot = a[high];   
        int left = low;
        int right = high - 1;
        int swap ;

        while(true)
        {
            // sap xep tang dan
            while(left <= right && a[left] < pivot)  // giam dan: a[left] > pivot
                left++;

            // sap xep tang dan
            while(left <= right && a[right] > pivot) // giam dan: a[right] < pivot
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

    static void quickSort(int a[], int low, int high)
    {
        if (low < high)
        {
            int pivot = partition(a, low, high);  // pivot la phan tu trung binh, 
                                                  // dung dung vi tri va dung lam vach ngan 
                                                  // de chia 2 mang trai va phai
     
            // Goi de quy sap xep 2 mang con trai va phai
            quickSort(a, low, pivot - 1);
            quickSort(a, pivot + 1, high);
        }
    }

    static void print(int[] a)
    {
        for(int i:a)
            System.out.print(i + " ") ;
        
        System.out.println() ;
    }

    public static void main(String[] args) 
    {
        int[] a = new int[]{1,6,2,4,8,10,5} ;

        System.out.print("Mang da nhap: ") ;
        print(a);

        quickSort(a, 0, a.length - 1);

        System.out.print("Mang sau khi sap xep: ") ;
        print(a);
    }
}