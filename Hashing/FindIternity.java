import java.util.*;

public class FindIternity {
    public static void main(String[] args) {
        HashMap<String, String> fromTo = new HashMap<>();
        HashMap<String, String> toFrom = new HashMap<>();

        //initially given
        fromTo.put("Mumbai", "Delhi");
        fromTo.put("Chennai", "Banglore");
        fromTo.put("Goa", "Chennai");
        fromTo.put("Delhi", "Goa");

        Set<String> keys = fromTo.keySet();
        for(String e: keys){
            toFrom.put(fromTo.get(e), e);
        }
        String start = "";
        for(String s: keys){
            if(!toFrom.containsKey(s)){
                start = s;
                break;
            }
        }
        System.out.print(start);
        start = fromTo.get(start);
        for(int i = 0; i < keys.size(); i++){
            System.out.print("->"+start);
            start = fromTo.get(start);
        }
    }
}
