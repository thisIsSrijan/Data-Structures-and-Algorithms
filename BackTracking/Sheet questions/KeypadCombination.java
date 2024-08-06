
public class KeypadCombination {
    static char keypad[][] = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};

    public static void find_combination(String digits, StringBuilder sb, int i){
        if(i == digits.length() || digits.length() == 0){
            System.out.println(sb.toString());
            return;
        }

        char c[] = keypad[Character.getNumericValue(digits.charAt(i))];
        if(c.length == 0){
            find_combination(digits, new StringBuilder(sb).append(""), i+1);
        }
        for(int j = 0; j< c.length; j++){
            find_combination(digits, new StringBuilder(sb).append(c[j]), i+1);
        }
    }
    public static void main(String[] args) {
        find_combination("303", new StringBuilder(), 0);
    }
}
