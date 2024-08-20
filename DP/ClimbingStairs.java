import java.util.*;

public class ClimbingStairs {
    //recursion
    public static int countWays(int n){
        if(n == 0)
            return 1;
        if(n < 0)
            return 0;

        return countWays(n-1) + countWays(n-2);
    }

    //memoization
    public static long countWays(int n, long dp[]){
        if(n == 0)
            return 1;
        if(n < 0)
            return 0;

        if(dp[n] != -1)
            return dp[n];

        dp[n] = countWays(n-1,dp) + countWays(n-2,dp);
        return dp[n];
    }

    //tabulation
    public static long countWays_tabulation(int n){
        long dp[] = new long[n+1];
        dp[0] = 1;

        for(int i = 1; i <= n; i++){
            if(i == 1)
                dp[i] = dp[i-1];
            else
                dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
    public static void main(String[] args) {
        int n = 10;
        System.out.println(countWays(n));
        long dp[] = new long[n+1];
        Arrays.fill(dp, -1);
        System.out.println(countWays(n, dp));
        System.out.println(countWays_tabulation(n));
        
    }
}
