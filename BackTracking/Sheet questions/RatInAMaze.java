//note: in the sheet, it is given that rat can move in any of the 4 directions
//But we only take right and bottom 
//the remaining two directions are automatically fulfilled by backtracking

public class RatInAMaze{
    public static boolean isSafe(int a[][], int curRow, int curCol){
        if(a[curRow][curCol] == 1)
            return true;
        
        return false;
    }

    public static void printMatrix(int a[][]){
        System.out.println("---solution exists---");
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a.length; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean find_ways(int a[][] , int b[][] , int row, int col){
        if(row == a.length - 1 && col == a.length - 1 && a[row][col] == 1){
            b[row][col] = 1;
            printMatrix(b);
            return true;
        }

        if(row == a.length || col == a.length || row == -1 || col == -1){
            return false;
        }

        if(isSafe(a, row, col)){
            b[row][col] = 1;
        }else{
            return false;
        }
            
        //go to any of the next move and if no solutions possible backtrack
        boolean x = find_ways(a, b, row, col+1) || find_ways(a, b, row+1, col);
        if(x == false){
            b[row][col] = 0;
        }

        return x;
    }
    public static void main(String[] args) {
        int a[][] = { { 1, 0, 0, 0 },
                      { 1, 1, 1, 1 },
                      { 0, 1, 0, 1 },
                      { 1, 1, 1, 1 } };

        int b[][] = new int[a.length][a.length];

        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a.length; j++){
                b[i][j] = 0;
            }
        }

        if(!find_ways(a, b, 0, 0))
            System.out.println("No solution exists");
    }
}