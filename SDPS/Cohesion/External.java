
//high semantic cohesion
class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) throw new ArithmeticException("Division by zero!");
        return a / b;
    }
}

//low semantic cohesion
class MixedUtility {
    public void printMessage() {
        System.out.println("Hello, World!");
    }

    public void sendEmail(String email) {
        System.out.println("Sending email to " + email);
    }

    public int calculateSum(int a, int b) {
        return a + b;
    }
}
