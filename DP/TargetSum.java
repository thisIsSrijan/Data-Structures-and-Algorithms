public class TargetSum {

    public static boolean isAchievable(int num[], int target){
        boolean dp[][] = new boolean[num.length+1][target+1];

        for(int i = 0; i < num.length + 1; i++){
            dp[i][0] = true;
        }

        //by default other values set as false
        //filling table
        for(int i = 1; i < num.length + 1; i++){
            for(int j = 1; j < target + 1; j++){
                if(num[i-1] <= j){
                    //include
                    if(dp[i-1][j - num[i-1]])
                        dp[i][j] = true;
                    //exclude
                    if(dp[i-1][j])
                        dp[i][j] = true;
                }else{
                    //exclude
                    if(dp[i-1][j])
                    dp[i][j] = true;
                }
            }
        }

        return dp[num.length][target];
    }
    public static void main(String[] args) {
        int num[] = {4,2,7,1,3};
        int target = 15;
        System.out.println(isAchievable(num, target));
    }
}
