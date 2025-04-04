public class Template {
    static abstract class Beverage{
        //template method
        public final void prepare(){
            boilWater();
            brew();
            pourInCup();
            if(customerWantsCodnimentsHook()){
                addCondiments();
            }
        }

        //to be implemented by subclasses
        abstract void brew();
        abstract void addCondiments();

        //default implementations
        void pourInCup(){
            System.out.println("Pouring in cup");
        }
        void boilWater(){
            System.out.println("Boiling water");
        }

        //hook method - mostly empty
        //subclasses can override this method
        boolean customerWantsCodnimentsHook(){
            return true;
        }
    }

    static class Tea extends Beverage{
        void brew(){
            System.out.println("Steeping the tea");
        }
        void addCondiments(){
            System.out.println("Adding lemon");
        }

        //overriding the hook method
        boolean customerWantsCodnimentsHook(){
            System.out.println("Do you want lemon with your tea? (y/n)");
            String answer = getUserInput();
            if(answer.toLowerCase().startsWith("y")){
                return true;
            }else{
                return false;
            }
        }
        String getUserInput(){
            // Simulate user input
            return "y"; // For demonstration purposes, always return "y"
        }
    }

    static class Coffee extends Beverage{
        void brew(){
            System.out.println("Dripping coffee through filter");
        }
        void addCondiments(){
            System.out.println("Adding sugar and milk");
        }
    }

    public static void main(String[] args) {
        // Template template = new Template();
        Beverage tea = new Tea();
        tea.prepare();

        Beverage coffee = new Coffee();
        coffee.prepare();
    }
}
