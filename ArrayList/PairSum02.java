
import java.util.ArrayList;

public class PairSum02 {
    public static int findPivot(ArrayList<Integer> list){
        int i = 0;
        while(i < list.size() - 1){
            if(list.get(i) > list.get(i + 1))
                return i;
            
            i++;
        }

        return i;
    }
    public static boolean findPairSum(ArrayList<Integer> list, int target){
        int size = list.size();
        int rp = findPivot(list);
        int lp = (rp + 1)%size;

        while(lp != rp){
            int x = list.get(lp) + list.get(rp);

            if(x == target){
                return true;
            }
            else if(x < target){
                lp = (lp + 1)%size;
            }
            else if(x > target){
                rp = (rp - 1 + size)%size;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        System.out.println(findPairSum(list, 16));
    }
}
