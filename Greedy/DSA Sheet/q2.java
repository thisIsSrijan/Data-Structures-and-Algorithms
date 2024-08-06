
public class q2{
    public static int kthLargest(int l, int r, int k){
        int totalOdds = 0;
        int max = 0;
        for(int i = r; i >= l; i--){
            if(totalOdds == k)
                return max;
            if(i%2 != 0){
                totalOdds++;
                max = i--;
            }
        }
        if(totalOdds == k)
            return max;
        return 0;
    }
    public static void main(String[] args) {
        System.out.println(kthLargest(-3, 3, 1));
    }
}