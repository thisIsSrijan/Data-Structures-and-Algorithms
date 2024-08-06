
public class BinaryString {
    public static void printBin(int n, int lastPlace, StringBuilder sb){
        if(n == 0){
            System.out.println(sb.toString());
            return;
        }
        printBin(n-1, 0, sb.append(0));
        sb.deleteCharAt(sb.length()-1);
        if(lastPlace == 0){
            printBin(n-1, 1, sb.append(1));
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public static void main(String[] args) {
        printBin(4, 0, new StringBuilder()); 
    }
}
