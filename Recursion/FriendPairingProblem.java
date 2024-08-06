
public class FriendPairingProblem {

    public static int calc_ways(int n){
        if(n == 0 || n == 1 || n == 2)
            return n;
        
        //calculate nC2
        int totalWays = (n-1)*calc_ways(n-2) + calc_ways(n-1);

        return totalWays;
    }
    public static void main(String[] args) {
        System.out.println(calc_ways(3));
    }
}
