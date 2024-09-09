public class LCSubstring {
    public static int lcs(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int max = 0;
        int dp[][] = new int[n+1][m+1];

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(lcs("ABCDE", "ABGCE"));
    }
}
