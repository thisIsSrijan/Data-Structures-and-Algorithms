
public class StringCompression {

    public static String compress(String s){
        StringBuilder sb = new StringBuilder();
        Integer count = 1;
        for(int i = 0; i < s.length(); i++){
            while(i < s.length()-1 && s.charAt(i) == s.charAt(i + 1)){
                count++;
                i++;
            }
            sb.append(s.charAt(i));
            if(count > 1){
                sb.append(count);
            }
            count = 1;
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "abbbccdddde";
        System.out.println(compress(s));
    }
}
