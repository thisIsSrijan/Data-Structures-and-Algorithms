package Design_Patterns.Observer;

import java.util.ArrayList;
import java.util.List;

public class Observer {
    // Observer Interface
    static interface Subscriber {

        void update(String videoTitle);
    }

    //Subject Interface
    static interface YouTubeChannel {

        void subscribe(Subscriber subscriber);

        void unsubscribe(Subscriber subscriber);

        void notifySubscribers(String videoTitle);
    }

    // Concrete Subject (YouTube Channel)
    static class MyYouTubeChannel implements YouTubeChannel {

        private List<Subscriber> subscribers = new ArrayList<>();

        @Override
        public void subscribe(Subscriber subscriber) {
            subscribers.add(subscriber);
        }

        @Override
        public void unsubscribe(Subscriber subscriber) {
            subscribers.remove(subscriber);
        }

        @Override
        public void notifySubscribers(String videoTitle) {
            for (Subscriber subscriber : subscribers) {
                subscriber.update(videoTitle);
            }
        }

        public void uploadVideo(String title) {
            System.out.println("New Video Uploaded: " + title);
            notifySubscribers(title);
        }
    }

    // Concrete Observer (Subscriber)
    static class User implements Subscriber {

        private String name;

        public User(String name) {
            this.name = name;
        }

        @Override
        public void update(String videoTitle) {
            System.out.println(name + " received notification: New video uploaded - " + videoTitle);
        }
    }

    public static void main(String[] args) {
        // Create a YouTube Channel
        MyYouTubeChannel techChannel = new MyYouTubeChannel();

        // Create subscribers
        User user1 = new User("Alice");
        User user2 = new User("Bob");

        // Users subscribe to the channel
        techChannel.subscribe(user1);
        techChannel.subscribe(user2);

        // Upload a new video
        techChannel.uploadVideo("Observer Pattern in Java");

        // Bob unsubscribes
        techChannel.unsubscribe(user2);

        // Upload another video
        techChannel.uploadVideo("Strategy Pattern Explained");
    }
}
