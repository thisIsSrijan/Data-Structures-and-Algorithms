public class Inheritance {
    static class Car {
        void startEngine() {
            System.out.println("Starting the engine");
        }
    }
    
    static class ElectricCar extends Car {  // Inherits from Car
        void startEngine() {
            System.out.println("Starting the electric motor");
        }
    }
    
    public static void main(String[] args) {
        Car car = new ElectricCar();  // Static relationship
        car.startEngine(); // Will call ElectricCar's startEngine method
    }
    
}
