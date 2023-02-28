import java.io.* ;
import java.util.concurrent.ThreadLocalRandom ;
import java.util.* ;

public class Main
{
    static void createFile()
    {
        try
        {
            FileWriter writer100 = new FileWriter("input100.txt") ;  
            FileWriter writer1000 = new FileWriter("input1000.txt") ;  
            FileWriter writer10000 = new FileWriter("input10000.txt") ;  

            for(int i=0;i<100;i++)   writer100.write(ThreadLocalRandom.current().nextInt(1,101) + "\n") ;
            for(int i=0;i<1000;i++)  writer1000.write(ThreadLocalRandom.current().nextInt(1,1001) + "\n") ;            
            for(int i=0;i<10000;i++) writer10000.write(ThreadLocalRandom.current().nextInt(1,10001) + "\n") ;
            
            writer100.close() ;
            writer1000.close();
            writer10000.close();

        }catch(Exception e){
            System.out.println("Error when creating file !!") ; 
        }
    }

    static void input(int[] a100, int[] a1000, int[] a10000)
    {
        try
        {
            File reader100 = new File("input100.txt") ;  
            File reader1000 = new File("input1000.txt") ;  
            File reader10000 = new File("input10000.txt") ;  
            Scanner sc100 = new Scanner(reader100) ; 
            Scanner sc1000 = new Scanner(reader1000) ; 
            Scanner sc10000 = new Scanner(reader10000) ; 
            
            int i = 0 ;
            while(sc100.hasNextLine())    
            {
                a100[i] = Integer.parseInt(sc100.nextLine()) ;
                i++ ;
            }

            i = 0 ;
            while(sc1000.hasNextLine())    
            {
                a1000[i] = Integer.parseInt(sc1000.nextLine()) ;
                i++ ;
            }

            i = 0 ;
            while(sc10000.hasNextLine())    
            {
                a10000[i] = Integer.parseInt(sc10000.nextLine()) ;
                i++ ;
            }
            
            sc100.close() ;
            sc1000.close() ;
            sc10000.close() ;

        }catch(Exception e){
            System.out.println("Error when reading file !!") ; 
        }
    }

    static void copyToTempArray(int[] a, int[] temp)
    {
        for(int i=0;i<a.length;i++)
            temp[i] = a[i] ;
    }

    static void writeDataToExcel(long timeSelectionSort100, long timeSelectionSort1000, long timeSelectionSort10000,
    long timeBubbleSort100, long timeBubbleSort1000, long timeBubbleSort10000,
    long timeInsertionSort100, long timeInsertionSort1000, long timeInsertionSort10000,
    long timeMergeSort100, long timeMergeSort1000, long timeMergeSort10000,
    long timeQuickSort100, long timeQuickSort1000, long timeQuickSort10000,
    long timeRadixSort100, long timeRadixSort1000, long timeRadixSort10000)
    {
        try
        {
            FileWriter writer = new FileWriter("evaluateSortingAlgorithms.csv") ;  
            
            writer.write(",Selection Sort,Bubble Sort,Insertion Sort,Merge Sort,Quick Sort,Radix Sort\n") ;
            writer.write("100,"+timeSelectionSort100+","+timeBubbleSort100+","+timeInsertionSort100+","+timeMergeSort100+","+timeQuickSort100+","+timeRadixSort100+"\n");            
            writer.write("1000,"+timeSelectionSort1000+","+timeBubbleSort1000+","+timeInsertionSort1000+","+timeMergeSort1000+","+timeQuickSort1000+","+timeRadixSort1000+"\n");            
            writer.write("10000,"+timeSelectionSort10000+","+timeBubbleSort10000+","+timeInsertionSort10000+","+timeMergeSort10000+","+timeQuickSort10000+","+timeRadixSort10000+"\n");            

            writer.close() ;
            System.out.println("Go to workspace to see excel (.csv) file !!") ;

        }catch(Exception e){
            System.out.println("Error when writing to excel file !!") ; 
        }
    }

    public static void main(String[] args) 
    {
        int[] a100 = new int[100] ; 
        int[] a1000 = new int[1000] ; 
        int[] a10000 = new int[10000] ; 
        int[] temp100 = new int[100] ; 
        int[] temp1000 = new int[1000] ; 
        int[] temp10000 = new int[10000] ;

        createFile();
        input(a100, a1000, a10000);

        // SELECTION SORT
        SelectionSort selectionSort = new SelectionSort() ;

        copyToTempArray(a100, temp100);
        long timeSelectionSort100 = selectionSort.sort(temp100) ;

        copyToTempArray(a1000, temp1000);
        long timeSelectionSort1000 = selectionSort.sort(temp1000) ;

        copyToTempArray(a10000, temp10000);
        long timeSelectionSort10000 = selectionSort.sort(temp10000) ;

        selectionSort.output(temp100, temp1000, temp10000) ;

        // BUBBLE SORT
        BubbleSort bubbleSort = new BubbleSort() ;

        copyToTempArray(a100, temp100);
        long timeBubbleSort100 = bubbleSort.sort(temp100) ;

        copyToTempArray(a1000, temp1000);
        long timeBubbleSort1000 = bubbleSort.sort(temp1000) ;

        copyToTempArray(a10000, temp10000);
        long timeBubbleSort10000 = bubbleSort.sort(temp10000) ;

        bubbleSort.output(temp100, temp1000, temp10000) ;

        // INSERTION SORT
        InsertionSort insertionSort = new InsertionSort() ;

        copyToTempArray(a100, temp100);
        long timeInsertionSort100 = insertionSort.sort(temp100) ;

        copyToTempArray(a1000, temp1000);
        long timeInsertionSort1000 = insertionSort.sort(temp1000) ;

        copyToTempArray(a10000, temp10000);
        long timeInsertionSort10000 = insertionSort.sort(temp10000) ;

        insertionSort.output(temp100, temp1000, temp10000) ;

        // MERGE SORT
        MergeSort ms = new MergeSort() ;

        long timeStartMergeSort100 = System.currentTimeMillis() ;
        copyToTempArray(a100, temp100);
        ms.mergeSort(temp100, 0, temp100.length - 1) ;
        long timeMergeSort100 = System.currentTimeMillis() - timeStartMergeSort100 ;

        long timeStartMergeSort1000 = System.currentTimeMillis() ;
        copyToTempArray(a1000, temp1000);
        ms.mergeSort(temp1000, 0, temp1000.length - 1) ;
        long timeMergeSort1000 = System.currentTimeMillis() - timeStartMergeSort1000 ;

        long timeStartMergeSort10000 = System.currentTimeMillis() ;
        copyToTempArray(a10000, temp10000);
        ms.mergeSort(temp10000, 0, temp10000.length - 1) ;
        long timeMergeSort10000 = System.currentTimeMillis() - timeStartMergeSort10000 ;

        ms.output(temp100, temp1000, temp10000) ;

        // QUICK SORT
        QuickSort qs = new QuickSort() ;

        long timeStartQuickSort100 = System.currentTimeMillis() ;
        copyToTempArray(a100, temp100);
        qs.quickSort(temp100, 0, temp100.length - 1) ;
        long timeQuickSort100 = System.currentTimeMillis() - timeStartQuickSort100 ;

        long timeStartQuickSort1000 = System.currentTimeMillis() ;
        copyToTempArray(a1000, temp1000);
        qs.quickSort(temp1000, 0, temp1000.length - 1) ;
        long timeQuickSort1000 = System.currentTimeMillis() - timeStartQuickSort1000 ;

        long timeStartQuickSort10000 = System.currentTimeMillis() ;
        copyToTempArray(a10000, temp10000);
        qs.quickSort(temp10000, 0, temp10000.length - 1) ;
        long timeQuickSort10000 = System.currentTimeMillis() - timeStartQuickSort10000 ;

        qs.output(temp100, temp1000, temp10000) ;

        // RADIX SORT
        RadixSort rs = new RadixSort() ;

        long timeStartRadixSort100 = System.currentTimeMillis() ;
        copyToTempArray(a100, temp100);
        rs.radixSort(temp100, temp100.length) ;
        long timeRadixSort100 = System.currentTimeMillis() - timeStartRadixSort100 ;

        long timeStartRadixSort1000 = System.currentTimeMillis() ;
        copyToTempArray(a1000, temp1000);
        rs.radixSort(temp1000, temp1000.length) ;
        long timeRadixSort1000 = System.currentTimeMillis() - timeStartRadixSort1000 ;

        long timeStartRadixSort10000 = System.currentTimeMillis() ;
        copyToTempArray(a10000, temp10000);
        rs.radixSort(temp10000, temp10000.length) ;
        long timeRadixSort10000 = System.currentTimeMillis() - timeStartRadixSort10000 ;

        rs.output(temp100, temp1000, temp10000) ;

        // write data and evaluate Sorting Algorithms to excel file
        writeDataToExcel(timeSelectionSort100, timeSelectionSort1000, timeSelectionSort10000,
        timeBubbleSort100, timeBubbleSort1000, timeBubbleSort10000,
        timeInsertionSort100, timeInsertionSort1000, timeInsertionSort10000,
        timeMergeSort100, timeMergeSort1000, timeMergeSort10000,
        timeQuickSort100, timeQuickSort1000, timeQuickSort10000,
        timeRadixSort100, timeRadixSort1000, timeRadixSort10000);
    }
}