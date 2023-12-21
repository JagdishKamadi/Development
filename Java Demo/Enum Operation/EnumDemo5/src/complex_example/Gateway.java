package complex_example;

import java.util.function.Consumer;

public enum Gateway {
    ACQ_DPG(name -> System.out.println(name)),
    ACQ_UNIONPAY(name -> System.out.println(name)),
    ACQ_NPCI(name -> System.out.println(name));

    private Consumer<String> acquirerName;

    Gateway(Consumer<String> acquirerName) {
        this.acquirerName = acquirerName;
    }

    public void useConsumer(String acqName) {
        acquirerName.accept(acqName);
    }
}
