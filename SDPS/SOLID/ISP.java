// ISP - Interface Segregation Principle


//not following ISP

// interface Worker {
//     void work();
//     void eat();
// }

// class Developer implements Worker {
//     @Override
//     public void work() {
//         System.out.println("Writing code...");
//     }

//     @Override
//     public void eat() {
//         System.out.println("Eating lunch...");
//     }
// }

// class Robot implements Worker {
//     @Override
//     public void work() {
//         System.out.println("Performing automated tasks...");
//     }

//     @Override
//     public void eat() {
//         // ❌ A robot does not eat, but it's forced to implement this method
//         throw new UnsupportedOperationException("Robots do not eat!");
//     }
// }
// The Robot class is forced to implement the eat() method even though it doesn't make sense for a robot to eat. This violates the Interface Segregation Principle. To fix this, we can create a separate interface for the eat() method:


public class ISP {
    interface Workable {
        void work();
    }
    
    interface Eatable {
        void eat();
    }
    
    class Developer implements Workable, Eatable {
        @Override
        public void work() {
            System.out.println("Writing code...");
        }
    
        @Override
        public void eat() {
            System.out.println("Eating lunch...");
        }
    }
    
    class Robot implements Workable {
        @Override
        public void work() {
            System.out.println("Performing automated tasks...");
        }
    }

    public static void main(String[] args) {
        ISP isp = new ISP();
        Developer developer = isp.new Developer();
        developer.work();
        developer.eat();
    
        Robot robot = isp.new Robot();
        robot.work();
    }
    
}