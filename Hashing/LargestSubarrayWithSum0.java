import java.util.*;

public class LargestSubarrayWithSum0 {
    public static int findSubArray(int a[]){
        HashMap<Integer, Integer> sum = new HashMap<>();
        int s = 0;
        int l = 0;
        for(int i = 0; i < a.length; i++){
            s+= a[i];
            if(sum.containsKey(s)){
                l = Math.max(l, i - sum.get(s));
            }else{
                sum.put(s, i);
            }
        }

        return l;
    }
    public static void main(String[] args) {
        int a[] = {15,-2,2,-8,1,7,10};
        
        System.out.println(findSubArray(a));
    }
}
