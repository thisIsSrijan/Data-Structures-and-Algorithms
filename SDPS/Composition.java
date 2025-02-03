
public class Composition {

    static class Engine {

        void start() {
            System.out.println("Engine starting");
        }
    }

    static class ElectricEngine extends Engine {

        @Override
        void start() {
            System.out.println("Electric engine starting");
        }
    }

    static class DieselEngine extends Engine {

        @Override
        void start() {
            System.out.println("Diesel engine starting");
        }
    }

    static class Car {

        private Engine engine;  // Composition: Car has an Engine

        public void setEngine(Engine engine) {  // Dynamically change Engine at runtime
            this.engine = engine;
        }

        void start() {
            engine.start();  // Delegates the starting task to the Engine object
        }
    }

    public static void main(String[] args) {
        Car car = new Car();

        Engine electricEngine = new ElectricEngine();
        Engine dieselEngine = new DieselEngine();

        car.setEngine(electricEngine);  // Set engine to ElectricEngine
        car.start(); // Output: Electric engine starting

        car.setEngine(dieselEngine);  // Change engine to DieselEngine dynamically at runtime
        car.start(); // Output: Diesel engine starting
    }

}
