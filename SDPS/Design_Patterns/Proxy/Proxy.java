
import java.util.ArrayList;
import java.util.List;

public class Proxy {

    //subject interface
    interface Internet {

        void connect(String server);
    }

    //real subject which does most of the work
    static class RealInternet implements Internet {

        public void connect(String server) {
            System.out.println("connected to " + server);
        }
    }

    //proxy subject to control access to real subject
    static class ProxyInternet implements Internet{
        private Internet realInternet = new RealInternet();
        private static List<String> bannedSites;

        static {
            bannedSites = new ArrayList<>();
            bannedSites.add("abc.com");
            bannedSites.add("xyz.com");
        }

        public void connect(String server){
            if(bannedSites.contains(server.toLowerCase())){
                System.out.println("The site you are trying to connect is banned");
            }
            else{
                realInternet.connect(server);
            }
        }
    }

    public static void main(String[] args) {
        Internet internet = new ProxyInternet(); //client thinks he is connected to real internet

        internet.connect("chatgpt.com");
        internet.connect("xyz.com");
    }
}


//Lazy initialization using Proxy pattern

// Subject Interface
// interface Image {
//     void display();
// }

// // Real Subject
// class RealImage implements Image {
//     private String filename;

//     public RealImage(String filename) {
//         this.filename = filename;
//         loadFromDisk(); // Heavy operation
//     }

//     private void loadFromDisk() {
//         System.out.println("Loading " + filename);
//     }

//     public void display() {
//         System.out.println("Displaying " + filename);
//     }
// }

// // Proxy Class
// class ProxyImage implements Image {
//     private RealImage realImage;
//     private String filename;

//     public ProxyImage(String filename) {
//         this.filename = filename;
//     }

//     public void display() {
//         // Only load the image when display is called
//         if (realImage == null) {
//             realImage = new RealImage(filename);
//         }
//         realImage.display();
//     }
// }

// // Client
// public class VirtualProxyDemo {
//     public static void main(String[] args) {
//         Image image = new ProxyImage("photo.jpg");

//         System.out.println("Image object created");
//         System.out.println("Now calling display()...");

//         image.display(); // RealImage is loaded and displayed here
//         System.out.println("Calling display() again...");

//         image.display(); // This time it's already loaded
//     }
// }
