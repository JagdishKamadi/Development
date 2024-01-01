package observer;

public class Subscriber {
    private String name;

    public Subscriber() {

    }

    public Subscriber(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void update(String name) {
        System.out.printf("Hi %s new video has uploaded %s", name, "\n");
    }
}
