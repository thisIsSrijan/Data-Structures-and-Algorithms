


public class MaxSubArray {
    //brute force
    public static int calcMaxSumBF(int arr[]){
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            int start=i;
            for(int j=i; j<arr.length; j++){
                int end=j;
                currSum=0;
                for(int k=start;k<=end;k++){
                    currSum += arr[k];
                }
                if(currSum > maxSum)
                    maxSum= currSum;
            }
        }
        return maxSum;
    }

    //using prefix array
    public static int calcMaxSumPA(int arr[]){
        int prefixArr[] = new int[arr.length];
        prefixArr[0] = arr[0];
        for(int i=1;i<arr.length;i++){
            prefixArr[i] = prefixArr[i-1]+ arr[i];
        }

        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i=0; i< arr.length; i++){
            int start=i;
            for(int j=i; j<arr.length;j++){
                int end = j;
                if(start==0){
                    currSum=prefixArr[end];
                }else{
                    currSum = prefixArr[end] - prefixArr[start-1];
                }
                
                if(maxSum<currSum)
                    maxSum=currSum;
            }
        }

        return maxSum;
    }

    //Kadane's Algorithm
    public static int calcMaxSumKA(int arr[]){
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++){
            if(currSum<0)
                currSum=0;
            currSum+= arr[i];
            if(currSum>maxSum)
                maxSum=currSum;
        }

        return maxSum;
    }
    public static void main(String[] args) {
        int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(calcMaxSumBF(a));
        System.out.println(calcMaxSumPA(a));
        System.out.println(calcMaxSumKA(a));
    }
}
