public class KnapSack {
    //recursion O(2^n)
    public static int maxProfit(int val[], int wt[], int W, int n){
        if(W == 0 || n == 0)
            return 0;
        
        if(wt[n-1] <= W){
            //include current object
            int a1 = val[n-1] + maxProfit(val, wt, W-wt[n-1], n-1);
            //exclude current object
            int a2 = maxProfit(val, wt, W, n-1);
            return Math.max(a1, a2);
        }else{
            return maxProfit(val, wt, W, n-1);
        }
    }

    //memoization O(n*W)
    public static int maxProfit(int val[], int wt[], int dp[][], int W, int n){
        if(W == 0 || n == 0)
            return 0;
        
        if(dp[n-1][W-1] != -1){
            return dp[n-1][W-1];
        }

        if(wt[n-1] <= W){
            //include current object
            int a1 = val[n-1] + maxProfit(val, wt, W-wt[n-1], n-1);
            //exclude current object
            int a2 = maxProfit(val, wt, W, n-1);
            dp[n-1][W-1] = Math.max(a1, a2);

            return dp[n-1][W-1];
        }else{
            dp[n-1][W-1] = maxProfit(val, wt, W, n-1);
            return dp[n-1][W-1];
        }
    }

    //tabulation
    public static int maxProfit_tabulation(int val[], int wt[], int W, int n){
        //initialization
        int dp[][] = new int[n+1][W+1];
        for(int i = 0; i < n+1; i++){
            dp[i][0] = 0;
        }
        for(int i = 0; i < W+1; i++){
            dp[0][i] = 0;
        }

        //filling table
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < W+1; j++){
                if(wt[i-1] <= j){
                    int p1 = val[i-1] + dp[i-1][j - wt[i-1]];
                    int p2 = dp[i-1][j];
                    dp[i][j] = Math.max(p1, p2);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][W];
    }
    public static void main(String[] args) {
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W = 7;
        int n = 5;
        int dp[][] = new int[n+1][W+1];
        for(int i = 0; i <=n ; i++){
            for(int j = 0; j <= W; j++){
                dp[i][j] = -1;
            }
        }
        //recursion
        System.out.println(maxProfit(val, wt, W, n));
        //memoization
        System.out.println(maxProfit(val, wt, dp, W, n));
        //tabulation
        System.out.println(maxProfit_tabulation(val, wt, W, n));
    }
}
