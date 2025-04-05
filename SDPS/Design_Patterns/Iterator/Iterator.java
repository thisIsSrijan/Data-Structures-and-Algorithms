public class Iterator{
    //See class diagram on page 331 in the book for better understanding

    //Object structure
    static class MenuItem{
        String name;
        String description;
        boolean vegetarian;
        double price;

        public MenuItem(String name, String description, boolean vegetarian, double price){
            this.name = name;
            this.description = description;
            this.vegetarian = vegetarian;
            this.price = price;
        }

        public String getName(){
            return name;
        }

        public String getDescription(){
            return description;
        }

        public boolean isVegetarian(){
            return vegetarian;
        }

        public double getPrice(){
            return price;
        }
    }

    //Iterator interface
    interface CustomIterator{
        boolean hasNext();
        Object next();
    }

    //Concrete iterator
    static class DinnerMenuIterator implements CustomIterator{
        MenuItem[] items;
        int position = 0;

        public DinnerMenuIterator(MenuItem[] items){
            this.items = items;
        }

        public boolean hasNext(){
            return position < items.length && items[position] != null;
        }

        public Object next(){
            MenuItem menuItem = items[position];
            position++;
            return menuItem;
        }
    }

    //Aggregate interface
    interface Menu{
        CustomIterator createIterator();
    }

    //Concrete aggregate
    static class DinnerMenu implements Menu{
        static final int MAX_ITEMS = 6;
        MenuItem[] menuItems;
        int numberOfItems = 0;

        public DinnerMenu(){
            menuItems = new MenuItem[MAX_ITEMS];
            addItem("Vegetarian BLT", "(Fakin') Bacon with lettuce & tomato on whole wheat", true, 2.99);
            addItem("BLT", "Bacon with lettuce & tomato on whole wheat", false, 2.99);
        }

        public void addItem(String name, String description, boolean vegetarian, double price){
            MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
            if(numberOfItems >= MAX_ITEMS){
                System.out.println("Sorry, menu is full! Can't add item to menu");
            } else {
                menuItems[numberOfItems] = menuItem;
                numberOfItems++;
            }
        }

        public CustomIterator createIterator(){
            return new DinnerMenuIterator(menuItems);
        }
    }

    //Client
    //The client uses the iterator to traverse the collection
    static class Waitress{
        DinnerMenu dinnerMenu;

        public Waitress(DinnerMenu dinnerMenu){
            this.dinnerMenu = dinnerMenu;
        }

        public void printMenu(){
            CustomIterator iterator = dinnerMenu.createIterator();
            System.out.println("MENU\n----\nBREAKFAST");
            printMenu(iterator);
        }

        public void printMenu(CustomIterator iterator){
            while(iterator.hasNext()){
                MenuItem menuItem = (MenuItem) iterator.next();
                System.out.print(menuItem.getName() + ", ");
                System.out.print(menuItem.getPrice() + " -- ");
                System.out.println(menuItem.getDescription());
            }
        }
    }
    public static void main(String[] args){
        DinnerMenu dinnerMenu = new DinnerMenu();
        Waitress waitress = new Waitress(dinnerMenu);
        waitress.printMenu();
    }
    
}