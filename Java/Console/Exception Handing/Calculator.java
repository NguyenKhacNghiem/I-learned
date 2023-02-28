public class Calculator
{
    public int phepNhan(int a, int b)
    {
        if(a< -1000 || a>1000 || b< -1000 || b>1000)    // dat dieu kien la a, b thuoc [-1000;1000]
            throw new NumberOutOfRangeException("Vuot qua pham vi tinh toan") ; 

        return a*b ; 
    }

    public double phepChia(int a, int b)
    {
        if(a< -1000 || a>1000 || b< -1000 || b>1000)    // dat dieu kien la a, b thuoc [-1000;1000]
            throw new NumberOutOfRangeException("Vuot qua pham vi tinh toan") ; 

        if(b==0)
            throw new ArithmeticException("Loi chia cho so 0") ; // exception nay co san trong Java, throw == return 
        
        return (a*1.0)/b ; 
    }

    public static void main(String[] args)
    {
        // Do 2 methods tren khong co chu "static" nen ta phai goi qua doi tuong thuoc class do
        Calculator myCal = new Calculator() ;  // Constructor khong doi so luon co san 

        System.out.println(myCal.phepNhan(3,2000)) ; // do cau lenh nay co loi (chay vo throw) nen chuong trinh se return tai day
        System.out.println(myCal.phepChia(3,0)) ;    // do cau lenh nay co loi (chay vo throw) nen chuong trinh se return tai day
 
        System.out.println(myCal.phepNhan(3,5)) ;    // ko dc thuc hien
    }
}