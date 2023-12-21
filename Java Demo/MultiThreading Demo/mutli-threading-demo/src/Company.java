public class Company {

    private Integer quantity;

    /**
     * flag=false : chance for producer
     * flag=true : chance for consumer
     */
    private boolean flag = false;

    public synchronized  void produceItem(Integer quantity) throws InterruptedException {

        if (flag) {
            wait();
        }

        this.quantity = quantity;
        System.out.println("Produced : " + this.quantity);
        flag = true;
        notifyAll();
    }

    public  synchronized  Integer consumeItem() throws InterruptedException {

        if (!flag) {
            wait();
        }
        System.out.println("Consumed : " + this.quantity);
        flag = false;
        notifyAll();
        return this.quantity;
    }
}
