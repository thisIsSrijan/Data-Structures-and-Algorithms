public class OCP {
    // Interface for flying behavior

    public interface FlyBehavior {

        void fly();
    }

// Interface for quacking behavior
    public interface QuackBehavior {

        void quack();
    }

// Class for ducks that fly with wings
    public class FlyWithWings implements FlyBehavior {

        @Override
        public void fly() {
            System.out.println("I'm flying with wings!");
        }
    }

// Class for ducks that cannot fly
    public class FlyNoWay implements FlyBehavior {

        @Override
        public void fly() {
            System.out.println("I can't fly.");
        }
    }

// Class for ducks that quack
    public class Quack implements QuackBehavior {

        @Override
        public void quack() {
            System.out.println("Quack!");
        }
    }

// Class for ducks that squeak
    public class Squeak implements QuackBehavior {

        @Override
        public void quack() {
            System.out.println("Squeak!");
        }
    }

// Class for ducks that are silent
    public class MuteQuack implements QuackBehavior {

        @Override
        public void quack() {
            System.out.println("...");
        }
    }

    public abstract class Duck {

        FlyBehavior flyBehavior;
        QuackBehavior quackBehavior;

        public Duck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
            this.flyBehavior = flyBehavior;
            this.quackBehavior = quackBehavior;
        }

        public void performFly() {
            flyBehavior.fly();
        }

        public void performQuack() {
            quackBehavior.quack();
        }

        public void swim() {
            System.out.println("All ducks float, even decoys!");
        }

        public abstract void display();
    }

    public class MallardDuck extends Duck {

        public MallardDuck() {
            super(new FlyWithWings(), new Quack());
        }

        @Override
        public void display() {
            System.out.println("I'm a real Mallard duck.");
        }
    }

    public class RubberDuck extends Duck {

        public RubberDuck() {
            super(new FlyNoWay(), new Squeak());
        }

        @Override
        public void display() {
            System.out.println("I'm a rubber duck.");
        }
    }

    public class DecoyDuck extends Duck {

        public DecoyDuck() {
            super(new FlyNoWay(), new MuteQuack());
        }

        @Override
        public void display() {
            System.out.println("I'm a decoy duck.");
        }
    }

}
