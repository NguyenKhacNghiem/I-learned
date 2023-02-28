public class HeapSort
{
    static void heapSort(int a[]) 
    {
        // Xay dung Heap (sap xep lai mang)
        for (int i = a.length / 2 - 1 ; i >= 0 ; i--)
            heapify(a, a.length, i);

        // Trich xuat phan tu tu Heap
        for (int i = a.length - 1 ; i > 0 ; i--) 
        {
            // Di chuyen root hien tai den end
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;

            // Vun dong lai
            heapify(a, i, 0);
        }
    }

    static void heapify(int a[], int n, int i) 
    {
        int largest = i;   // largest = root
        int left = 2 * i;     
        int right = 2 * i + 1; 

        // node con ben trai > root
        if (left < n && a[left] > a[largest])
            largest = left;

        // node con ben phai > root
        if (right < n && a[right] > a[largest])
            largest = right;

        // neu largest != root
        if (largest != i) 
        {
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;

            // Vun dong lai cac cay con bi anh huong
            heapify(a, n, largest);
        }
    }

    public static void main(String args[]) 
    {
        int a[] = { 4, 10, 3, 5, 1 };

        heapSort(a);

        for(int i:a)
            System.out.print(i+" ") ;
    }
}