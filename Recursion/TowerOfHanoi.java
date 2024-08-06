
public class TowerOfHanoi{
    public static void shift(int n, char source, char helper, char destination){
        if(n == 1){
            System.out.println("shift"+n+"st disk from "+source+" to "+destination);
            return;
        }
        shift(n-1, source, destination, helper);
        System.out.println("shift"+n+"th disk from "+source+" to "+destination);
        shift(n-1, helper, source, destination);
    }

    public static void main(String[] args) {
        shift(3, 'A', 'B', 'C');
    }
}