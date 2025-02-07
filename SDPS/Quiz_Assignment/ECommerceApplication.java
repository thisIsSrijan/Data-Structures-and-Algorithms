//22ucs212
//Srijan Das

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

//--------------- Databases ---------------

// Interface for Database operations
interface Database {
    void connect();
}

// UsersDB extending Database interface
class UsersDB implements Database {
    public void connect() {
        System.out.println("Connected to Users Database.");
    }
}

// ProductDB extending Database interface
class ProductDB implements Database {
    public void connect() {
        System.out.println("Connected to Products Database.");
    }
}

//-------------- User --------------

// Interface for User
interface UserRole {
    void verifyUser(Database db);
    void updateProfile(String address, String phone, String email);
    void login();
}

// Customer class
class Customer implements UserRole {
    private String id;
    private String address;
    private String phone;
    private String email;
    private Cart cart;

    //Register a customer
    public Customer(String id, String address, String phone, String email) {
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.cart = new Cart();
        System.out.println("Customer created successfully.");
    }

    public void verifyUser(Database db) {
        db.connect();
        System.out.println("Verifying customer ID: " + id);
    }

    public void updateProfile(String address, String phone, String email) {
        this.address = address;
        this.phone = phone;
        this.email = email;
        System.out.println("Customer profile updated successfully.");
    }

    public void login() {
        System.out.println("Customer: "+this.id+" logged in successfully.");
    }

    public Cart getCart() {
        return cart;
    }
}

//Seller class
class Seller implements UserRole {
    private String id;
    private String address;
    private String phone;
    private String email;
    private ArrayList<Product> products; //Products sold by seller

    //Register a seller
    public Seller(String id, String address, String phone, String email) {
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.products = new ArrayList<>();
        System.out.println("Seller created successfully.");
    }

    public void verifyUser(Database db) {
        db.connect();
        System.out.println("Verifying seller ID: " + id);
    }

    public void updateProfile(String address, String phone, String email) {
        this.address = address;
        this.phone = phone;
        this.email = email;
        System.out.println("Seller profile updated successfully.");
    }

    public void login() {
        System.out.println("Seller "+this.id+" logged in successfully.");
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added successfully by seller.");
    }
}

//------- Products ---------
class Product {
    private String productId;
    private String name;
    private String sellerId;
    private int cost;
    private int stockUnits;

    public Product(String productId, String name, String sellerId, int cost, int stockUnits) {
        this.productId = productId;
        this.name = name;
        this.sellerId = sellerId;
        this.cost = cost;
        this.stockUnits = stockUnits;
    }

    public void addToCart(Cart cart) {
        if(stockUnits > 0){
            cart.addProduct(this);
            stockUnits--;
        }else{
            System.out.println("product out of stock!");
        }
    }

    public void getDetails() {
        System.out.println("Product ID: " + productId + ", Name: " + name + ", Price: $" + cost);
    }

    //for direct buying without adding to cart
    public void buy(Customer customer) {
        if (stockUnits > 0) {
            stockUnits--;
            Payment payment = new Payment();
            String orderId = UUID.randomUUID().toString();

            Order order = new Order(payment, orderId, customer, cost);
            order.placeOrder();

            System.out.println("Product purchased successfully! Order ID: " + orderId);
        } else {
            System.out.println("Out of stock! Unable to purchase.");
        }
    }

    public void getProductDetails() {
        System.out.println(this.name+" : "+this.cost);
    }

    public int getCost(){
        return this.cost;
    }
}

//------- Cart -------
class Cart {
    private ArrayList<Product> products;
    private int totalItems;
    private int totalCost;

    public Cart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        totalItems++;
        totalCost += product.getCost();
        System.out.println("Product added to cart.");
    }

    public void checkout(Payment payment, Customer customer) {
        if (products.isEmpty()) {
            System.out.println("Cart is empty. Add products before checkout.");
            return;
        }

        String orderId = UUID.randomUUID().toString();
        Order order = new Order(payment, orderId, customer, totalCost);
        order.placeOrder();
        products.clear();
        totalItems = 0;
        totalCost = 0;
    }

    public void viewCart() {
        System.out.println("Cart contains " + totalItems + " items. Total cost: Rs. " + totalCost);
    }
}

//---------- Payment ----------
class Payment {
    private String transactionId;
    private String orderId;
    private boolean paid;
    private int total;
    private Date date;

    public Payment() {
        this.transactionId = UUID.randomUUID().toString();
        this.date = new Date();
    }

    public void sendOTP() {
        System.out.println("OTP sent for transaction verification.");
    }

    public void confirmTransaction() {
        paid = true;
        System.out.println("Transaction confirmed successfully.");
    }

    public void makeTransaction(int totalAmount) {
        this.total = totalAmount;
        sendOTP();
        confirmTransaction();
        System.out.println("Transaction ID: " + transactionId + ", Amount: Rs." + total);
    }
}

//Order class associated with Payment class
class Order {
    private Payment payment;
    private String orderId;
    private Customer customer;
    private int totalAmount;
    private String status;

    public Order(Payment payment, String orderId, Customer customer, int totalAmount) {
        this.payment = payment;
        this.orderId = orderId;
        this.customer = customer;
        this.totalAmount = totalAmount;
        this.status = "Pending";
    }

    public void placeOrder() {
        System.out.println("Order placed successfully. Order ID: " + orderId);
        payment.makeTransaction(totalAmount);
        this.status = "Completed";
    }

    public void getStatus() {
        System.out.println("Order Status: " + status);
    }

    public void getDetail() {
        System.out.println("Order ID: " + orderId + ", Total Amount: Rs. " + totalAmount);
    }
}

//UI
class UserApplicationUI {
    public void displayUI() {
        System.out.println("User Interface Loaded.");
    }
}


public class ECommerceApplication {
    public static void main(String[] args) {
        UserApplicationUI ui = new UserApplicationUI();
        ui.displayUI();

        Database userDb = new UsersDB();
        Database productDb = new ProductDB();

        //Creating a customer and verifying user
        Customer customer = new Customer("C001", "123 Street", "9999999999", "customer@example.com");
        customer.verifyUser(userDb);
        customer.login();

        //Creating a seller and adding products
        Seller seller = new Seller("S001", "456 Avenue", "8888888888", "seller@example.com");
        seller.verifyUser(userDb);
        seller.login();

        Product product1 = new Product("P101", "Laptop", "S001", 800, 10);
        Product product2 = new Product("P102", "Phone", "S001", 500, 20);

        seller.addProduct(product1);
        seller.addProduct(product2);

        //Customer adding products to cart
        Cart cart = customer.getCart();
        product1.addToCart(cart);
        product2.addToCart(cart);
        cart.viewCart();

        //Checkout process
        Payment payment = new Payment();
        cart.checkout(payment, customer);
    }
}