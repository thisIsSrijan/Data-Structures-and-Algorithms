import java.util.Stack;

public class ValidParanthesis {
    public static char opening[] = {'(' , '[', '{'};
    public static char closing[] = {')' , ']', '}'};

    public static boolean isOpening(char c){
        for(int i = 0; i < opening.length; i++){
            if(c == opening[i])
                return true;
        }
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

    public static boolean validate(String str){
        Stack <Character> s = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(isOpening(c))
                s.push(c);
            else{
                //c is a closing character
                if(isMatched(c, s.peek()))
                    s.pop();
                else
                    return false;
            }
        }

        if(s.isEmpty())
            return true;
        
        return false;
    }
    public static void main(String[] args) {
        System.out.println(validate("(}"));
    }
}
