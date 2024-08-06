
import java.util.*;


public class BeautifulArrayList {

    public static void printer(ArrayList<Integer> list){
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
    public static void findBeauty(int n){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);

        for(int i = 2; i <= n; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            for (Integer e : list) {
                if((2*e) <= n)
                    temp.add(e*2);
            }

            for (Integer e : list) {
                if((2*e - 1) <= n)
                    temp.add(e*2 - 1);
            }

            list = temp;
        }

        printer(list);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = sc.nextInt();
        findBeauty(n);
    }
}
