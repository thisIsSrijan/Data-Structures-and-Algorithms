import java.util.*;
public class q2 {
    public static int connectRopes(int n, int a[]){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < a.length; i++){
            pq.add(a[i]);
        }
        int cost = 0;
        while(pq.size() > 1){
            int first = pq.poll();
            int second = pq.poll();
            int ropeCost = first + second;
            cost += ropeCost;
            pq.add(ropeCost);
        }

        return cost;
    }
    public static void main(String[] args) {
        int a[] = {4,3,2,6};
        System.out.println(connectRopes(a.length, a));
    }
}
