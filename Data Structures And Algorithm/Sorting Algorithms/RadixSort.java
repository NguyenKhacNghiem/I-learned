import java.util.* ;

public class RadixSort
{
    // Lay gia tri lon nhat trong mang
    static int getMax(int a[], int n)
    {
        int max = a[0];
        
        for (int i = 1; i < n; i++)
            if (a[i] > max)
                max = a[i];

        return max;
    }
 
    // Sap xep theo chu so duoc bieu dien bang exp
    static void countSort(int a[], int n, int exp)
    {
        int output[] = new int[n]; 
        int count[] = new int[10];  // 10 la cac don vi de so sanh (dv, chuc, tram,...)
        int i;
        Arrays.fill(count, 0);  // them tat ca so 0 vao mang count[]
 
        // Luu so lan xuat hien duoc dem trong count
        for (i = 0; i < n; i++)
            count[(a[i] / exp) % 10]++;
 
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
 
        // Xay dung ham output
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
    static void radixSort(int a[], int n)
    {
        // Tim so lon nhat de biet so lon nhat chua bao nhieu chu so
        int max = getMax(a, n);
 
        // Tien hanh sap xep theo tung chu so o tung hang dv, chuc, tram,...
        for (int exp = 1; max / exp > 0; exp *= 10)
            countSort(a, n, exp);
    }

    static void print(int[] a)
    {
        for(int i:a)
            System.out.print(i + " ") ;

        System.out.println() ;
    }
 
    public static void main(String[] args) 
    {
        int[] a = new int[]{12, 11, 13, 5, 6, 7};
        
        System.out.print("Mang da cho: ");
        print(a);
        
        radixSort(a, a.length);

        System.out.print("Mang sau khi sap xep: ");
        print(a);
    }
}