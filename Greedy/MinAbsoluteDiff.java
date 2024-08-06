import java.util.Arrays;

public class MinAbsoluteDiff {
    public static int findSum(int a[], int b[]){
        int minDiff = 0;
        Arrays.sort(a);
        Arrays.sort(b);
        for(int i = 0; i < a.length; i++){
            minDiff += Math.abs(a[i] - b[i]);
        }

        return minDiff;
    }
    public static void main(String[] args) {
        int a[] = {50, 15, 70, 30};
        int b[] = {15, 50, 1, 7};
        System.out.println(findSum(a, b));
    }
}
