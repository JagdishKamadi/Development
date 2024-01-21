import complex_example.Gateway;
import simple_example.Scheme;

public class Main {
    public static void main(String[] args) {
        Scheme scheme = Scheme.VISA;
        scheme.cardName();

        Gateway acqDpg = Gateway.ACQ_DPG;
        acqDpg.useConsumer("acqDpgService");

        Gateway acqUnionPay = Gateway.ACQ_UNIONPAY;
        acqDpg.useConsumer("acqUnionPayService");

    }
}