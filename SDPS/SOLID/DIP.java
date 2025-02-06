// Description: Dependency Inversion Principle

// Low-level module (depends on a concrete implementation)
// class WiredKeyboard {
//     void type() {
//         System.out.println("Typing with a wired keyboard...");
//     }
// }
// // High-level module (directly depends on WiredKeyboard)
// class Computer {
//     private WiredKeyboard keyboard;  // ❌ Tight coupling
//     public Computer() {
//         this.keyboard = new WiredKeyboard();  // ❌ Direct dependency
//     }
//     public void start() {
//         keyboard.type();
//     }
// }
// public class Main {
//     public static void main(String[] args) {
//         Computer computer = new Computer();
//         computer.start();
//     }
// }
//Computer directly depends on WiredKeyboard, which violates the Dependency Inversion Principle and also violates 
//OCP as we need to modify Computer class to change a keyboard. To fix this, we can introduce an abstraction (interface) 
//between the high-level and low-level modules:
public class DIP {
    // Step 1: Create an abstraction (interface)

    interface Keyboard {

        void type();
    }

// Step 2: Implement concrete classes
    class WiredKeyboard implements Keyboard {

        public void type() {
            System.out.println("Typing with a wired keyboard...");
        }
    }

    class WirelessKeyboard implements Keyboard {

        public void type() {
            System.out.println("Typing with a wireless keyboard...");
        }
    }

// Step 3: High-level module depends on abstraction (not concrete class)
    class Computer {

        private Keyboard keyboard;

        // Dependency Injection via Constructor
        public Computer(Keyboard keyboard) {
            this.keyboard = keyboard;
        }

        public void start() {
            keyboard.type();
        }
    }

    public static void main(String[] args) {
        Computer computer = new DIP().new Computer(new DIP().new WiredKeyboard());
        computer.start();

        Computer computer2 = new DIP().new Computer(new DIP().new WirelessKeyboard());
        computer2.start();
    }

    //High-level module (Computer) does NOT depend on low-level modules (WiredKeyboard, WirelessKeyboard) directly.
    //Low-level modules (WiredKeyboard, WirelessKeyboard) depend on an abstraction (Keyboard).
    
}
