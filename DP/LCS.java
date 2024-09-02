public class LCS{
    //memoization
    public static int findLcs(String str1, int l1, String str2, int l2, int dp[][]){
        if(dp[l1][l2] != -1)
            return dp[l1][l2];
        
        //base case
        if(l1 == 0 || l2 == 0){
            dp[l1][l2] = 0;
            return dp[l1][l2];
        }
        
        //last character same
        if(str1.charAt(l1-1) == str2.charAt(l2-1)){
            dp[l1][l2] = 1 + findLcs(str1, l1 - 1, str2, l2 - 1, dp);
        }else{
            dp[l1][l2] = Math.max(findLcs(str1, l1-1, str2, l2,dp), findLcs(str1, l1, str2, l2-1, dp));
        }

        return dp[l1][l2];
    }

    //tabulation
    public static int findLcs(String str1, String str2){
        int dp[][] = new int[str1.length()+1][str2.length()+1];
        //initialization
        for(int i = 0; i < dp.length; i++){
            dp[i][0] = 0;
        }
        for(int i = 0; i < dp[0].length; i++){
            dp[0][i] = 0;
        }

        //filling the table
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }     
        }

        return dp[str1.length()][str2.length()];
    }
    public static void main(String[] args) {
        int dp[][] = new int[6][4];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++)
                dp[i][j] = -1;
        }
        System.out.println(findLcs("abcde", 5, "ace",3, dp));
        System.out.println(findLcs("abcde", "ace"));
    }
}