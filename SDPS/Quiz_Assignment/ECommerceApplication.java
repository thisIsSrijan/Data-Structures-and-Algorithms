// //22ucs212
// //Srijan Das

import java.util.*;

// ------- Database Layer -------
interface Database {

    void connect();
}

class UsersDB implements Database {

    public void connect() {
        System.out.println("Connected to Users Database.");
    }
}

class ProductDB implements Database {

    public void connect() {
        System.out.println("Connected to Products Database.");
    }
}

// ------- User Role Interfaces -------
interface Verifiable {

    void verifyUser(Database db);
}

interface ProfileUpdatable {

    void updateProfile(String address, String phone, String email);
}

interface Authenticatable {

    void login();
}

// ------- User Classes -------
abstract class User implements Verifiable, ProfileUpdatable, Authenticatable {

    protected String id, address, phone, email;

    public User(String id, String address, String phone, String email) {
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public void verifyUser(Database db) {
        db.connect();
        System.out.println("Verifying user ID: " + id);
    }

    public void updateProfile(String address, String phone, String email) {
        this.address = address;
        this.phone = phone;
        this.email = email;
        System.out.println("Profile updated successfully.");
    }
}

class Customer extends User {

    private Cart cart = new Cart();

    public Customer(String id, String address, String phone, String email) {
        super(id, address, phone, email);
    }

    public void login() {
        System.out.println("Customer " + this.id + " logged in.");
    }

    public Cart getCart() {
        return this.cart;
    }
}

class Seller extends User {

    private List<Product> products = new ArrayList<>();

    public Seller(String id, String address, String phone, String email) {
        super(id, address, phone, email);
    }

    public void login() {
        System.out.println("Seller " + this.id + " logged in.");
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added successfully by seller: "+this.id);
    }
}

// ------- Product Class -------
class Product {

    private String productId, name, sellerId;
    private int cost, stockUnits;

    public Product(String productId, String name, String sellerId, int cost, int stockUnits) {
        this.productId = productId;
        this.name = name;
        this.sellerId = sellerId;
        this.cost = cost;
        this.stockUnits = stockUnits;
    }

    public void addToCart(Cart cart) {
        if (stockUnits > 0) {
            cart.addProduct(this);
            stockUnits--;
        } else {
            System.out.println("Product out of stock!");
        }
    }

    public void getProductDetails() {
        System.out.println(this.name + " : " + this.cost);
    }

    public int getCost() {
        return this.cost;
    }
}

// ------- Cart Class -------
class Cart {

    private List<Product> products = new ArrayList<>();
    private int totalCost;

    public void addProduct(Product product) {
        products.add(product);
        totalCost += product.getCost();
        System.out.println("Product added to cart.");
    }

    public void checkout(PaymentProcessor paymentProcessor, Customer customer) {
        if (products.isEmpty()) {
            System.out.println("Cart is empty. Add products before checkout.");
            return;
        }

        Order order = new Order(paymentProcessor, UUID.randomUUID().toString(), customer, totalCost);
        order.placeOrder();
    }
}

// ------- Payment Processing -------
interface PaymentProcessor {

    void processPayment(int amount);
}

class CreditCardPayment implements PaymentProcessor {

    public void processPayment(int amount) {
        System.out.println("Processing credit card payment of Rs. " + amount);
    }
}

class UpiPayment implements PaymentProcessor {

    public void processPayment(int amount) {
        System.out.println("Processing UPI payment of Rs. " + amount);
    }
}

// ------- Order Class -------
class Order {

    private PaymentProcessor paymentProcessor;
    private String orderId;
    private Customer customer;
    private int totalAmount;
    private String status;

    public Order(PaymentProcessor paymentProcessor, String orderId, Customer customer, int totalAmount) {
        this.paymentProcessor = paymentProcessor;
        this.orderId = orderId;
        this.customer = customer;
        this.totalAmount = totalAmount;
        this.status = "Pending";
    }

    public void placeOrder() {
        System.out.println("Order placed successfully. Order ID: " + orderId);
        paymentProcessor.processPayment(totalAmount);
        this.status = "Completed";
    }

    public void getStatus() {
        System.out.println("Order Status: " + status);
    }

    public void getDetail() {
        System.out.println("Order ID: " + orderId + ", Total Amount: Rs. " + totalAmount);
    }
}

// ------- UI Class -------
class UserApplicationUI {

    public void displayUI() {
        System.out.println("User Interface Loaded.");
    }
}

// ------- Main Application -------
public class ECommerceApplication {

    public static void main(String[] args) {
        UserApplicationUI ui = new UserApplicationUI();
        ui.displayUI();

        Database userDb = new UsersDB();

        Customer customer = new Customer("C001", "C scheme, Rajasthan", "9999999999", "customer@gmail.com");
        customer.verifyUser(userDb);
        customer.login();

        Seller seller = new Seller("S001", "Palika Bazar, Delhi", "8888888888", "seller@gmail.com");
        seller.verifyUser(userDb);
        seller.login();

        Product product1 = new Product("P101", "Laptop", "S001", 800, 10);
        Product product2 = new Product("P102", "Phone", "S001", 500, 20);

        seller.addProduct(product1);
        seller.addProduct(product2);

        Cart cart = customer.getCart();
        product1.addToCart(cart);
        product2.addToCart(cart);

        PaymentProcessor paymentProcessor = new CreditCardPayment();
        cart.checkout(paymentProcessor, customer);
    }
}