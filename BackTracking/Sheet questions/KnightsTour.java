



public class KnightsTour {
    /* xMove[] and yMove[] define next move of Knight.
     xMove[] is for next value of x coordinate
     yMove[] is for next value of y coordinate */
    static int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
    static int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

    public static void printMatrix(int a[][]){
        System.out.println("\n---solution exists---\n");
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a.length; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isSafe(int a[][], int row, int col){
        if(row >= a.length || col >= a.length || row <0 || col <0)
            return false;
        else if(a[row][col] == 0)
            return true;
        else
            return false;
    }

    public static boolean find_sequence(int a[][], int row, int col, int i){
        if(i == Math.pow(a.length, 2)){
            printMatrix(a);
            return true;
        }

        if(row == a.length || col == a.length || row == -1 || col == -1){
            return false;
        }

        //knight's move
        for(int j = 0; j< xMove.length; j++){
            if(isSafe(a, row, col)){
                a[row][col] = i++;
                if(!find_sequence(a, row+xMove[j], col+yMove[j], i)){
                    i--;
                    a[row][col] = 0;
                }else{
                    return true;
                }
             }
        }
        return false;
    }

    public static boolean KnightsTourUtil(int n){
        int a[][] = new int[n][n];
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < n; j++){
                a[i][j] = 0;
            }
        }
        return find_sequence(a, 0, 0, 0);
    }
    public static void main(String[] args) {
        if(!KnightsTourUtil(8))
            System.out.println("solution does not exists");
    }
}
