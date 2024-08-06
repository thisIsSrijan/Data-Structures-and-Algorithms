
public class Fibonacci{
    //O(2^n)
    public static int find_nth_term(int n){
        if(n==1 || n==2){
            return 1;
        }
        int a = find_nth_term(n-1);
        int b = find_nth_term(n-2);

        return a+b;
    }
    public static void main(String[] args) {
        System.out.println(find_nth_term(1));
    }
}