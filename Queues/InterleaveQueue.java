import java.util.*;

public class InterleaveQueue {
    public static void interleave(Queue<Integer> q){
        int size = q.size();
        Queue<Integer> q2 = new LinkedList<>();
        for(int i = 0; i < size/2; i++){
            q2.add(q.remove());
        }
        while(!q2.isEmpty()){
            q.add(q2.remove());
            q.add(q.remove());
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        int i = 1;
        while(i < 11){
            q.add(i++);
        }
        interleave(q);
        while(!q.isEmpty()){
            System.out.print(q.remove()+" ");
        }
    }
}
