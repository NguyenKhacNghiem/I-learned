public class Thread2 extends Thread
{
    public Thread1 thread1;

    public void setThread1(Thread1 thread1)
    {
        this.thread1 = thread1;
    }

    @Override
    public void run()
    {
        thread2Function();
    }

    public synchronized void thread2Function()
    {
        System.out.println("Waiting thread 1 complete...") ;

        thread1.thread1Function();
    }
}