
public class Abstraction {
    // Abstract class

    static abstract class Animal {
        // Abstract method (does not have a body)

        public abstract void sound();

        // Regular method
        public void sleep() {
            System.out.println("This animal is sleeping");
        }
    }

// Subclass (inherited from Animal)
    static class Dog extends Animal {
        // Providing the implementation of abstract method

        public void sound() {
            System.out.println("The dog barks");
        }
    }

    public static void main(String[] args) {
        // Creating an object of the subclass
        Animal myDog = new Dog(); //Animal class does not need to worry about how the sound method is implemented in Dog class

        myDog.sound();  // Output: The dog barks
        myDog.sleep();  // Output: This animal is sleeping
    }

}
