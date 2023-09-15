// Cach 1: implements Interface Runnable

public class Thread1 implements Runnable
{
    // Phuong thuc mac dinh chua cac dong code de chay trong Thread
    @Override
    public void run()
    {
        for(int i=1;i<=10;i++)
        {
            System.out.println("Thread1: " + i) ; 

            try {
                Thread.sleep(1000);  // Thread tam thoi ngung trong 1s. Dung ham sleep() phai co try-catch
            } catch (Exception e) {
                e.printStackTrace(); // Chi ghi ";" cung duoc
            }
        }
    }
}