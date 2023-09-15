public class MyThread implements Runnable
{
    public int n = 0 ;

    public synchronized void increaseN()
    {
        if(n == 0)
        {
            try {
                Thread.sleep(1000);  
            } catch (Exception e) {
                ; 
            }

            n++;
        }
        
        System.out.println(n) ; // Ket qua mong doi: 1-1. Khong them tu khoa "synchronized" ket qua se la 2-2
    }

    @Override
    public void run()
    {
        increaseN();
    }
}