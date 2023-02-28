public class MyThread extends Thread
{
    @Override
    public void run()
    {
        for(int i=1;i<=5;i++)
        {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                ;
            }

            System.out.println(this.getName() + ": " + i) ; // lay ten thread. Ham getName() mac dinh co san
        }
    }
}