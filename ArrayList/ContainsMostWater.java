
import java.util.ArrayList;


public class ContainsMostWater {
    //bruteforce O(n^2)
    public static int calculateAreaBF(ArrayList<Integer> list, int width){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < list.size(); i++){
            for(int j = i+1; j < list.size(); j++){
                int height = Math.min(list.get(i), list.get(j));
                int totalWidth = (j - i)*width;
                max = Math.max(max, totalWidth*height);
            }
        }

        return max;
    }

    //optimised 2-pointer approach
    public static int calculateAreaO(ArrayList<Integer> list , int width){
        int max = Integer.MIN_VALUE;
        int lp  = 0;
        int rp = list.size() - 1;

        while(lp < rp){
            int totalWidth = (rp - lp)*width;
            int height = Math.min(list.get(lp), list.get(rp));
            max = Math.max(max, height*totalWidth);

            if(list.get(lp) < list.get(rp))
                lp++;
            else
                rp--;
        }

        return max;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(8);
        list.add(6);
        list.add(2);
        list.add(5);
        list.add(4);
        list.add(8);
        list.add(3);
        list.add(7);
        System.out.println(calculateAreaO(list, 1));
    }
}
