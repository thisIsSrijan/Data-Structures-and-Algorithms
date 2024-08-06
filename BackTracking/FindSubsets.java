
public class FindSubsets {
    public static void find_subsets(String str, StringBuilder sb, int i){
        if(i == str.length()){
            System.out.println(sb.toString());
            return;
        }

        sb.append(str.charAt(i)); //yes
        find_subsets(str, sb, i+1);
        sb.deleteCharAt(sb.length() - 1); //no IMPORTANT!! SET THE CORRECT INDEX (WHICH IS LAST AND NOT i)
        find_subsets(str, sb, i+1);
    }
    public static void main(String[] args) {
        String str = "abc";
        find_subsets(str, new StringBuilder(), 0);
    }
}
