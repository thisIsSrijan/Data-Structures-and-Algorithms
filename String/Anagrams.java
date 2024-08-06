import java.util.Arrays;


public class Anagrams {
    public static boolean check_anagram(String s1, String s2){
        char a1[] = s1.toCharArray();
        char a2[] = s2.toCharArray();
        
        if(a1.length!=a2.length){
            return false;
        }

        Arrays.sort(a1);
        Arrays.sort(a2);
        for(int i = 0 ; i< a1.length; i++){
            if(a1[i]!=a2[i])
                return false;
        }
        //could use Arrays.equal(a1,a2) as well

        return true;
    }
    public static void main(String[] args) {
     System.out.println(check_anagram("rice", "care"));   
    }
}
