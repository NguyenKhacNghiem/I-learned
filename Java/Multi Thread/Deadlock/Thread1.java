public class Thread1 extends Thread
{
    public Thread2 thread2;

    public void setThread2(Thread2 thread2)
    {
        this.thread2 = thread2;
    }

    @Override
    public void run()
    {
        thread1Function();
    }

    public synchronized void thread1Function()
    {
        System.out.println("Waiting thread 2 complete...") ;

        thread2.thread2Function();
    }
}