
public class TIleProblem {

    public static int calc_ways(int n){
        if(n == 0 || n == 1)
            return 1;

        return calc_ways(n-1)+calc_ways(n-2);
    }
    public static void main(String[] args) {
        System.out.println(calc_ways(3));
    }
}
