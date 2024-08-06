import java.util.*;

public class q4 {
    public static Queue<Integer> reverseK(int k, Queue<Integer> q){
        Stack<Integer> s = new Stack<>();
        int i = 0;
        int l = q.size();
        while(i < k){
            s.push(q.remove());
            i++;
        }
        while(!s.isEmpty())
            q.add(s.pop());
        while(i < l){
            q.add(q.remove());
            i++;
        }

        return q;
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i < 11; i++){
            q.add(i*10);
        }
        q = reverseK(5, q);
        while(!q.isEmpty())
            System.out.print(q.remove()+" ");
    }
}
