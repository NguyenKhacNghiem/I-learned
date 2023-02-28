class SelectionSort
{
    public static void main(String[] args)
    {
        int[] a = new int[]{1,3,4,6,7,2,5,8,10,9} ; 
        int min_index, temp ;

        for(int i=0;i<a.length-1;i++)
        {
            min_index = i ;

            // tim phan tu nho nhat trong mang
            for(int k=i+1;k<a.length;k++)
                if(a[k]<a[min_index])
                    min_index = k ;
            
            // doi cho phan tu nho nhat voi phan tu dau tien trong mang
            temp = a[i] ; 
            a[i] = a[min_index] ; 
            a[min_index] = temp ; 
        }

        for(int i:a)    
            System.out.println(i) ; 
                
    }
}