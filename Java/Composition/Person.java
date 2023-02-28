public class Person 
{
    private Job job;
   
    public Person()
    {
        this.job=new Job();    //khoi tao doi tuong, constructor ko doi so luon luon dc tao mac dinh
        job.setSalary(1000L);
    }

    public long getSalary() 
    {
        return job.getSalary();
    }
}