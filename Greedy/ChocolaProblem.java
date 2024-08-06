
import java.util.Arrays;
import java.util.Collections;

public class ChocolaProblem {
    public static void main(String[] args) {
        Integer costVer[] = {2, 1, 3, 1, 4};
        Integer costHor[] = {4, 1, 2};

        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int cost = 0;
        int hp = 1;
        int vp = 1;
        int h = 0; //pointer for horizontal
        int v = 0; //pointer for vertical

        while(h < costHor.length && v < costVer.length){
            if(costVer[v] <= costHor[h]){ //horizontal cut
                cost += (costHor[h++] * vp++);
            }else{
                cost += (costVer[v++] * hp++);
            }
        }

        while(h < costHor.length){
            cost += (costHor[h++] * vp++);
        }
        while(v < costVer.length){
            cost += (costVer[v++] * hp++);
        }

        System.out.println("Min cost:" + cost);
    }
}
