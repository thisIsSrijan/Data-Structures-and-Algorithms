public class StringConversion {
    //only print the number of insertions and deletions
    public static int findMinOp(String word1, String word2){
        int n = word1.length();
        int m = word2.length();
        int dp[][] = new int[n+1][m+1];

        //intialization
        for(int i =0; i < dp.length; i++){
            for(int j =0; j< dp[0].length; j++){
                if(i == 0)
                    dp[i][j] = j; //insertion
                else if(j == 0)
                    dp[i][j] = i; //deletion
            }
        }

        //tabulate
        for (int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1]; //no operations needed
                else
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])+1; //do 1 operation and add then no. of previous operations
            }
        }

        return dp[n][m];
    }
    public static void main(String[] args) {
        System.out.println(findMinOp("david", "lucy"));
    }
}
