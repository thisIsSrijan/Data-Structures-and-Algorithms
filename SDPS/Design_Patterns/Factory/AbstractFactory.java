//Ingredient interfaces
public interface Cheese {
    String toString();
}

public interface Sauce {
    String toString();
}

//Concrete Ingredients
public class ReggianoCheese implements Cheese {
    public String toString() {
        return "Reggiano Cheese";
    }
}

public class MozzarellaCheese implements Cheese {
    public String toString() {
        return "Mozzarella Cheese";
    }
}

public class MarinaraSauce implements Sauce {
    public String toString() {
        return "Marinara Sauce";
    }
}

public class PlumTomatoSauce implements Sauce {
    public String toString() {
        return "Plum Tomato Sauce";
    }
}

//Ingredient Factory Interface
public interface PizzaIngredientFactory {
    Cheese createCheese();
    Sauce createSauce();
}

//Concrete Ingredients Factory
public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    public Sauce createSauce() {
        return new MarinaraSauce();
    }
}

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {
    public Cheese createCheese() {
        return new MozzarellaCheese();
    }

    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }
}

//Pizza class 
public abstract class Pizza {
    String name;
    Cheese cheese;
    Sauce sauce;

    public abstract void prepare();

    public void bake() {
        System.out.println("Baking " + name);
    }

    public void cut() {
        System.out.println("Cutting " + name);
    }

    public void box() {
        System.out.println("Boxing " + name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

//Concrete pizza product: either NYCheesePizza or ChicagoCheesePizza based on ingredient factory
public class CheesePizza extends Pizza {
    PizzaIngredientFactory ingredientFactory;

    public CheesePizza(PizzaIngredientFactory factory) {
        this.ingredientFactory = factory;
    }

    public void prepare() {
        System.out.println("Preparing " + name);
        cheese = ingredientFactory.createCheese();
        sauce = ingredientFactory.createSauce();
        System.out.println("Adding " + cheese + " and " + sauce);
    }
}

//abstract store
public abstract class PizzaStore {
    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    protected abstract Pizza createPizza(String type);
}

//concrete stores
public class NYPizzaStore extends PizzaStore {
    protected Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();

        if (type.equals("cheese")) {
            pizza = new CheesePizza(ingredientFactory); //NYstyle cheese pizza
            pizza.setName("NY Style Cheese Pizza");
        }
        //other types of pizzas
        return pizza;
    }
}

public class ChicagoPizzaStore extends PizzaStore {
    protected Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new ChicagoPizzaIngredientFactory();

        if (type.equals("cheese")) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("Chicago Style Cheese Pizza");
        }
        return pizza;
    }
}

public class PizzaTestDrive {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        Pizza pizza1 = nyStore.orderPizza("cheese");
        System.out.println("Ordered a " + pizza1.getName() + "\n");

        Pizza pizza2 = chicagoStore.orderPizza("cheese");
        System.out.println("Ordered a " + pizza2.getName());
    }
}
