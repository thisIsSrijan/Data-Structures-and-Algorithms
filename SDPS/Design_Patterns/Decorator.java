// package Design_Patterns;

public class Decorator {
    // Component Interface
    static interface Coffee {

        String getDescription();

        double getCost();
    }

    // Concrete Component (Base Coffee)
    static class SimpleCoffee implements Coffee {

        @Override
        public String getDescription() {
            return "Plain Coffee";
        }

        @Override
        public double getCost() {
            return 5.0;  // Base price
        }
    }

    // Abstract Decorator
    static abstract class CoffeeDecorator implements Coffee {

        protected Coffee decoratedCoffee;

        public CoffeeDecorator(Coffee coffee) {
            this.decoratedCoffee = coffee;
        }

        @Override
        public String getDescription() {
            return decoratedCoffee.getDescription();
        }

        @Override
        public double getCost() {
            return decoratedCoffee.getCost();
        }
    }

    // Concrete Decorator 1: Add Milk
    static class MilkDecorator extends CoffeeDecorator {

        public MilkDecorator(Coffee coffee) {
            super(coffee);
        }

        @Override
        public String getDescription() {
            return super.getDescription() + ", Milk";
        }

        @Override
        public double getCost() {
            return super.getCost() + 1.5;  // Milk costs extra
        }
    }

    // Concrete Decorator 2: Add Sugar
    static class SugarDecorator extends CoffeeDecorator {

        public SugarDecorator(Coffee coffee) {
            super(coffee);
        }

        @Override
        public String getDescription() {
            return super.getDescription() + ", Sugar";
        }

        @Override
        public double getCost() {
            return super.getCost() + 0.5;  // Sugar costs extra
        }
    }

    // Concrete Decorator 3: Add Whipped Cream
    static class WhippedCreamDecorator extends CoffeeDecorator {

        public WhippedCreamDecorator(Coffee coffee) {
            super(coffee);
        }

        @Override
        public String getDescription() {
            return super.getDescription() + ", Whipped Cream";
        }

        @Override
        public double getCost() {
            return super.getCost() + 2.0;  // Whipped cream costs extra
        }
    }

    public static void main(String[] args) {
        // Base coffee
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + " - $" + coffee.getCost());

        // Add milk
        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription() + " - $" + coffee.getCost());

        // Add sugar
        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.getDescription() + " - $" + coffee.getCost());

        // Add whipped cream
        coffee = new WhippedCreamDecorator(coffee);
        System.out.println(coffee.getDescription() + " - $" + coffee.getCost());
    }
}
