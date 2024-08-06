import java.util.*;

public class FirstNonRepeatingCharInAStream {
    public static void printChars(String str){
        Queue<Character> q = new LinkedList<>();
        char freq[] = new char[26];

        for(int i = 0; i < 26; i++){
            freq[i] = 0;
        }

        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            q.add(c);
            freq[c - 'a']++;
            while(!q.isEmpty()){
                if(freq[q.peek() - 'a'] == 1){
                    System.out.println(q.peek());
                    break;
                }else{
                    q.remove();
                }
            }
            if(q.isEmpty())
                System.out.println("-1");
        }

    }
    public static void main(String[] args) {
        printChars("aabccxb");
    }
}
