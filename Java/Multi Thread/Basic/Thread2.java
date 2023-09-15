// Cach 2: extends Class Thread

public class Thread2 extends Thread
{
    // Phuong thuc mac dinh chua cac dong code de chay trong Thread
    @Override
    public void run()
    {
        for(int i=1;i<=10;i++)
        {
            System.out.println("Thread2: " + i) ;

            try {
                Thread.sleep(1000);  // Thread tam thoi ngung trong 1s. Dung ham sleep() phai co try-catch
            } catch (Exception e) {
                e.printStackTrace(); // Chi ghi ";" cung duoc
            }
        }
    }
}