package observer;

import java.util.ArrayList;
import java.util.List;

public class Channel {
    private String name;
    private String title;
    private List<Subscriber> subscriberList = new ArrayList<>();

    public Channel() {
    }

    public Channel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void subscribe(Subscriber subscriber) {
        subscriberList.add(subscriber);
    }

    public void unSubscribe(Subscriber subscriber) {
        subscriberList.remove(subscriber);
    }

    public void notifySubscriber() {
        subscriberList.stream()
                .map(Subscriber::getName)
                .forEach(Subscriber::update);
    }

    public void uploadVideo(String title) {
        this.title = title;
        notifySubscriber();
    }
}
