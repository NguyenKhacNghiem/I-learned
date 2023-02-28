// YEU CAU: MANG PHAI DUOC SAP XEP TRUOC
import java.util.Arrays ;

class BinarySearch
{
    static int binarySearch(int[] a, int left, int right, int key)
    {
        if(right>=left)  
        {
            int mid = left + (right-left)/2 ; // == (left+right)/2 nhung tranh bi tran
        
            if(a[mid]==key) 
                return mid ; 
        
            if(a[mid]>key)
                return binarySearch(a,left,mid-1,key) ; 
        
            if(a[mid]<key)
                return binarySearch(a,mid+1,right,key) ;
        }

        return -1 ; // khi right<left -> khong tim thay
    }
    public static void main(String[] args)
    {
        int[] a = new int[]{1,3,4,6,7,2,5,8,10,9} ;
        Arrays.sort(a) ; 
        int key = 4 ; // tim so 4 trong mang

        int result = binarySearch(a,0,a.length-1,key) ; 
        System.out.println(result) ;  // ket qua duoc xet dua tren vi tri cua mang sau khi da sx
    }
}