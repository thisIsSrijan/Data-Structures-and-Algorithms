class A{
    public void add(int a, int b){
        System.out.println("add1 called");
    }
    
    public void add(long a, long b){
        System.out.println("add2 called");
    }

    public void add(int a, long b){
        System.out.println("add3 called");
    }

    public void add(long a, int b){
        System.out.println("add4 called");
    }
}

abstract class animal{
    abstract void eat();
}

class Cat extends animal{
    public static void walk(){
        System.out.println("cat walks 1 step");
    }

    @Override
    void eat(){
        System.out.println("animal eats");
    }
}

public class Polymorphism{
    public static void main(String[] args) {
        // A obj = new A();
        // obj.add((long)0 , 0);
        Cat obj = new Cat();
        obj.walk();
        obj.eat();
    }
}