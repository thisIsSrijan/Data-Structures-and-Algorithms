public class Introduction {
    //DP using Memoization (Top Down)
    private static int fibonacci_nth_term_aux(int n, int[] dp){
        if(n == 1 || n == 0)
            return n;
        if(dp[n] != 0)
            return dp[n];
        dp[n] = fibonacci_nth_term_aux(n-1, dp) + fibonacci_nth_term_aux(n-2, dp);
        return dp[n];
    }

    public static int fibonacci_nth_term(int n){
        int dp[] = new int[n+1];
        return fibonacci_nth_term_aux(n, dp);
    }

    //DP using Tabulation (Bottom Up)
    public static int fibonacci_nth_term_tabulation(int n){
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(fibonacci_nth_term(6));
        System.out.println(fibonacci_nth_term_tabulation(6));
    }
}
