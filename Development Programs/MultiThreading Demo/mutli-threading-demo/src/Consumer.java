public class Consumer  extends  Thread{
    private Company company;

    public Consumer(Company company)
    {
        this.company = company;
    }

    @Override
    public void run()
    {
       while (true)
       {
           try {
               this.company.consumeItem();
              Thread.sleep(2000);
          }catch(InterruptedException e)
          {
              Thread.currentThread().interrupt();
          }
       }

    }
}
