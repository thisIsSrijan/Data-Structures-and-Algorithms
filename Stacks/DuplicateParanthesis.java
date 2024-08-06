import java.util.Stack;

public class DuplicateParanthesis {
    public static char opening[] = {'(' , '[', '{'};
    public static char closing[] = {')' , ']', '}'};

    public static boolean isOpening(char c){
        for(int i = 0; i < opening.length; i++){
            if(c == opening[i])
                return true;
        }
        return false;
    }

    public static boolean isClosing(char c){
        for(int i = 0; i < opening.length; i++){
            if(c == closing[i])
                return true;
        }
        return false;
    }

    public static boolean isVal(char c){
        if(!isOpening(c) && !isClosing(c))
            return true;
        return false;
    }

    public static boolean isMatched(char a, char b){
        //a is closing and b is opening
        for(int i = 0; i < 3; i++){
            if(a == closing[i] && b == opening[i])
                return true;
        }

        return false;
    }

    //we expect that the string is valid Parenthesis by default
    public static boolean isDup(String str){
        Stack<Character> s = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(!isClosing(c))
                s.push(c);
            else{
                int count = 0;
                while(!s.isEmpty()){
                    if(isMatched(c, s.peek())){
                        if(count < 1)
                            return true;
                        s.pop();
                        break;
                    }
                    if(isVal(s.peek())){
                        count++;
                        s.pop();
                    }
                }
            }
        }

        return false;
    }
    public static void main(String[] args) {
        System.out.println(isDup("((a+b)+ (c))"));
    }
}
