// Dung bo dem thoi gian cua Java de tinh thoi gian chay chuong trinh
// Uu diem: de dung, co san
// Khuyet diem: do chinh xac thap, thoi gian cua moi lan chay se thay doi
//              phu thuoc vao compiler, phan cung,...

class DoThoiGianChayChuongTrinh
{
    public static void main(String[] args) 
    {
        long start = System.currentTimeMillis() ;  // lay thoi gian hien tai -> bam dong ho 
    
        // tinh thoi gian chay vong lap ben duoi 
        long count = 0 ;
        for(int i=0;i<10000000;i++)
            count += i ;
        
        long stop = System.currentTimeMillis() ;  // lay thoi gian hien tai -> ngung dong ho

        System.out.println("Your program runs in " + (stop - start) + " milliseconds") ;
    }
}