import java.util.LinkedList;

public class JCF {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addFirst(1);
        ll.addFirst(2);
        System.out.println(ll);
        ll.removeLast();
        System.out.println(ll);
        // ListNode head = ll;

    }
}
