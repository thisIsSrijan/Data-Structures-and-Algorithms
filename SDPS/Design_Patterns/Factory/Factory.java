//simple factory

public class Factory {
    //product
    public static abstract class Pizza {
        String name;
    
        public void prepare() {
            System.out.println("Preparing " + name);
        }
    
        public void bake() {
            System.out.println("Baking " + name);
        }
    
        public void cut() {
            System.out.println("Cutting " + name);
        }
    
        public void box() {
            System.out.println("Boxing " + name);
        }
    
        public String getName() {
            return name;
        }
    }

    //Concrete products 

    public static class NYStyleCheesePizza extends Pizza {
        public NYStyleCheesePizza() {
            name = "NY Style Cheese Pizza";
        }
    }
    
    public static class ChicagoStyleCheesePizza extends Pizza {
        public ChicagoStyleCheesePizza() {
            name = "Chicago Style Cheese Pizza";
        }
    
        @Override
        public void cut() {
            System.out.println("Cutting " + name + " into square slices");
        }
    }

    //Pizza store
    public static abstract class PizzaStore {
        public Pizza orderPizza(String type) {
            Pizza pizza = createPizza(type);  // Factory Method
    
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
    
            return pizza;
        }
    
        // Factory Method to be implemented by subclasses
        protected abstract Pizza createPizza(String type);
    }
    
    //Concrete pizza stores
    public static class NYPizzaStore extends PizzaStore {
        @Override
        protected Pizza createPizza(String type) {
            if (type.equals("cheese")) {
                return new NYStyleCheesePizza();
            }
            // More types can be added
            return null;
        }
    }
    
    public static class ChicagoPizzaStore extends PizzaStore {
        @Override
        protected Pizza createPizza(String type) {
            if (type.equals("cheese")) {
                return new ChicagoStyleCheesePizza();
            }
            // More types can be added
            return null;
        }
    }
    
    
    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        Pizza pizza1 = nyStore.orderPizza("cheese");
        System.out.println("Ordered a " + pizza1.getName() + "\n");

        Pizza pizza2 = chicagoStore.orderPizza("cheese");
        System.out.println("Ordered a " + pizza2.getName());
    }
}
