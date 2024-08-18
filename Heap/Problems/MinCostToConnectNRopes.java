import java.util.*;

public class MinCostToConnectNRopes {
    public static int minCost(int ropes[]){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < ropes.length; i++){
            pq.add(ropes[i]);
        }
        int sol = 0;
        while(true){
            int p = pq.remove();
            if(pq.isEmpty())
                break;
            int q = pq.remove();
            int sum = p+q;
            sol += sum;
            pq.add(sum);
        }

        return sol;
    }
    public static void main(String[] args) {
        int ropes[] = {2,3,3,4,6};
        System.out.println(minCost(ropes));
    }
}
