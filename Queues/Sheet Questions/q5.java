import java.util.*;

public class q5 {
    public static void printMaxSubWithK(int k, int a[]){
        Deque<Integer> Qi = new LinkedList<>();
        int i;
        int n = a.length;
        for(i = 0; i < k; i++){
            while(!Qi.isEmpty() && a[i] >= a[Qi.peekLast()])
                Qi.removeLast();
            Qi.addLast(i);
        }
        for(;i<n;i++){
            System.out.print(a[Qi.peek()]+" ");
            while(!Qi.isEmpty() && Qi.peek() <= i - k)
                Qi.removeLast();
            while(!Qi.isEmpty() && a[i] >= a[Qi.peekLast()])
                Qi.removeLast();
            Qi.addLast(i);
        }
        System.out.print(a[Qi.peek()]);
    }
    public static void main(String[] args) {
        int a[] = {1,2,3,1,4,5,2,3,6};
        printMaxSubWithK(3, a);
    }
}
