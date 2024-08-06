
public class StaircaseSearch {
    public static boolean search_2d(int a[][], int key){
        int startRow = 0;
        int startCol = a[0].length - 1;

        while(startRow <a.length && startCol < a[0].length){
            if(key == a[startRow][startCol]){
                System.out.println("("+startRow+","+startCol+")");
                return true;
            }
            if(key > a[startRow][startCol])
                startRow += 1;
            if(key < a[startRow][startCol])
                startCol -= 1;
        }

        return false;
    }
    public static void main(String[] args) {
        int a[][] = {
                    {10, 20, 30, 40},
                    {15, 25, 35, 45},
                    {27, 29, 37, 48},
                    {32, 33, 39, 50}
                    };
        
        System.out.println(search_2d(a, 33));
    }
}
