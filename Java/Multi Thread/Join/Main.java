public class Main
{
    public static void main(String[] args) 
    {
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        MyThread myThread3 = new MyThread();

        // Doi ten cua cac thread. Ham setName() mac dinh co san
        myThread1.setName("Thread1");
        myThread2.setName("Thread2");
        myThread3.setName("Thread3");

        myThread1.start();
        try {
            myThread1.join(); // Khi thread1 chay xong het thi cac thread kia moi duoc phep chay
            // myThread1.join(1000); giong phia tren nhung chi cho chay doc lap trong 1s
        } catch (Exception e) {
            ;
        }

        myThread2.start();
        myThread3.start(); 
    }
}