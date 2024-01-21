public class Producer extends Thread{
    private Company company;

    public Producer(Company company)
    {
        this.company = company;
    }

    @Override
    public void run() {
        int i=1;

        while(i<10)
        {
            try {
                company.produceItem(i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            i++;
        }

    }

}
