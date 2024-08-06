import java.util.*;

public class q1 {
    public static void generateBin(int n){
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            int x = i;
            while(x != 0){
                q.add(x%2);
                x = x/2;
            }
            StringBuilder sb = new StringBuilder();
            while(!q.isEmpty()){
                sb.append(q.remove());
            }
            sb = sb.reverse();
            System.out.println(sb.toString());
        }
    }
    public static void main(String[] args) {
        generateBin(10);
    }
}
