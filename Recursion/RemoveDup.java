
public class RemoveDup {
    public static String removeDuplicacy_main(String s, StringBuilder sb, int i, boolean map[]){
        if(i == s.length())
            return sb.toString();
        
        int map_ind = s.charAt(i) - 'a';
        if(map[map_ind]){
            removeDuplicacy_main(s, sb, i+1, map);
        }else{
            sb.append(s.charAt(i));
            map[map_ind] = true;
            removeDuplicacy_main(s, sb, i+1, map);
        }

        return sb.toString();
    }

    public static String removeDuplicacy(String str){
        boolean map[] = new boolean[26];
        for (boolean b : map) {
            b = false;
        }
        StringBuilder sb = new StringBuilder();
        return removeDuplicacy_main(str, sb, 0, map);
    }
    public static void main(String[] args) {
        String str = "kkr";
        System.out.println(removeDuplicacy(str));
    }
}
 