import observer.Channel;
import observer.Subscriber;

public class Demo {
    public static void main(String[] args) {
        Channel channel = new Channel("JK");
        Subscriber s1 = new Subscriber("Jagdish");
        Subscriber s2 = new Subscriber("Madhur");
        Subscriber s3 = new Subscriber("Kunal");

        channel.subscribe(s1);
        channel.subscribe(s2);
        channel.subscribe(s3);

        channel.uploadVideo("Java in 60 minutes");
    }
}