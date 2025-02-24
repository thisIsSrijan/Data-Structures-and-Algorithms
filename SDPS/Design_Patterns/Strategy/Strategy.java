package Design_Patterns.Strategy;

public class Strategy {
    // PaymentStrategy Interface (Abstract Strategy)
    static interface PaymentStrategy {
        void pay(int amount);
    }
    // Credit Card Payment Strategy
    static class CreditCardPayment implements PaymentStrategy {
        private String cardNumber;

        public CreditCardPayment(String cardNumber) {
            this.cardNumber = cardNumber;
        }

        @Override
        public void pay(int amount) {
            System.out.println("Paid $" + amount + " using Credit Card: " + cardNumber);
        }
    }

    // UPI Payment Strategy
    static class UpiPayment implements PaymentStrategy {
        private String upiId;

        public UpiPayment(String upiId) {
            this.upiId = upiId;
        }

        @Override
        public void pay(int amount) {
            System.out.println("Paid $" + amount + " using UPI: " + upiId);
        }
    }

    // PayPal Payment Strategy
    static class PayPalPayment implements PaymentStrategy {
        private String email;

        public PayPalPayment(String email) {
            this.email = email;
        }

        @Override
        public void pay(int amount) {
            System.out.println("Paid $" + amount + " using PayPal: " + email);
        }
    }

    // Context Class (Uses the Payment Strategy)
    static class ShoppingCart {
        private PaymentStrategy paymentStrategy;

        // Set the Payment Strategy at runtime
        public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
            this.paymentStrategy = paymentStrategy;
        }

        // Execute the selected payment strategy
        public void checkout(int amount) {
            if (paymentStrategy == null) {
                System.out.println("Please select a payment method before checking out.");
            } else {
                paymentStrategy.pay(amount);
            }
        }

        public static void main(String[] args) {
            ShoppingCart cart = new ShoppingCart();

            // User chooses to pay with Credit Card
            cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456"));
            cart.checkout(500);  // Output: Paid $500 using Credit Card: 1234-5678-9012-3456

            // User changes payment method to UPI
            cart.setPaymentStrategy(new UpiPayment("user@upi"));
            cart.checkout(200);  // Output: Paid $200 using UPI: user@upi

            // User switches to PayPal
            cart.setPaymentStrategy(new PayPalPayment("user@example.com"));
            cart.checkout(300);  // Output: Paid $300 using PayPal: user@example.com
        }
    }


}
