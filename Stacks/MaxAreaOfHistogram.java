import java.util.*;

public class MaxAreaOfHistogram{
    public static int findMaxArea(int a[]){
        int n = a.length;
        Stack<Integer> s = new Stack<>();
        int nsr[] = new int[a.length];
        int nsl[] = new int[a.length];

        // next smallest right
        for(int i = n - 1; i >= 0; i--){
            while(!s.isEmpty() && a[s.peek()] >= a[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i] = 6;
            }else{
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        s = new Stack<>();

        // next smallest left
        for(int i = 0; i < n; i++){
            while(!s.isEmpty() && a[s.peek()] >= a[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i] = -1;
            }else{
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        //calculate max area
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, a[i]*Math.abs(nsr[i] - nsl[i] - 1));
        }

        return max;
    }
    public static void main(String[] args) {
        int a[] = {2, 1, 5, 6, 2, 3};
        System.out.println(findMaxArea(a));
    }
}