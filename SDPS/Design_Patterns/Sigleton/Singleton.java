public class Singleton{
    private static Singleton uniqueInstance;

    // Private constructor to prevent instantiation
    private Singleton() {}
    

    public static Singleton getInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }

    //other useful methods
}