import java.util.*;

public class HashSetIntro {
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();
        hs.add(1);
        hs.add(2);
        hs.add(3);

        Iterator it = hs.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
