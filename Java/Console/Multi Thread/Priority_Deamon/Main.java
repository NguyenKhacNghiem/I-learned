public class Main
{
    public static void main(String[] args) 
    {
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        MyThread myThread3 = new MyThread();

        myThread1.setName("Thread1");
        myThread2.setName("Thread2");
        myThread3.setName("Thread3");

        // Set muc do uu tien cho cac thread. Chi mang tinh y nghia chu chay thuc te thi chua chac da dung
        myThread1.setPriority(1);
        myThread2.setPriority(10);
        myThread3.setPriority(5);

        // myThread1.start();
        // myThread2.start();
        // myThread3.start(); 

        // Daemon Thread
        MyThread myThread4 = new MyThread();
        myThread4.setDaemon(true); // chuyen User Thread thanh Deamon Thread

        myThread4.setName("Thread4");
        myThread4.start(); // thread nay se khong duoc chay
        
        System.out.println(myThread4.isDaemon()) ;
    }
}