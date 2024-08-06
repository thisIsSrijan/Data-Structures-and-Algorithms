public class SudokuSolver {
    public static void printSudoku(int a[][]){
        for (int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int a[][], int curRow, int curCol, int val){
        //check same row
        for(int i = 0; i<a.length; i++){
            if(val == a[curRow][i])
                return false;
        }

        //check same column
        for(int i = 0; i<a.length; i++){
            if(val == a[i][curCol])
                return false;
        }

        //check for the grid
        int startRow = (curRow/3)*3;
        int startCol = (curCol/3)*3;

        for(int i = startRow; i< startRow+3; i++){
            for(int j = startCol; j< startCol + 3; j++){
                if(a[i][j] == val)
                    return false;
            }
        }
        
        return true;
    }

    public static boolean solve_sudoku(int s[][], int row, int col){
        if(row == s.length){
            //printSudoku(s);
            System.out.println("\n-solution exists-\n");
            printSudoku(s);
            return true;
        }
        //calculate for next level
        int nextRow = row;
        if(col == s.length){
            nextRow +=1;
            col = 0;
        }
        int nextCol = col + 1;

        if(s[row][col] != 0){
            return solve_sudoku(s, nextRow, nextCol);
        }

        for(int val=1; val<=9; val++){
            if(isSafe(s, row, col, val)){
                s[row][col] = val;
                // solve_sudoku(s, row, col+1);
                if(solve_sudoku(s, nextRow, nextCol)) // if upper level solution at this position of val
                    return true;

                s[row][col] = 0;//backtrack
            }
        }

        return false;
    }
    public static void main(String[] args) {
        int sudoku[][] = { {3, 0, 6, 5, 0, 8, 4, 0, 0},
        {5, 2, 0, 0, 0, 0, 0, 0, 0},
        {0, 8, 7, 0, 0, 0, 0, 3, 1},
        {0, 0, 3, 0, 1, 0, 0, 8, 0},
        {9, 0, 0, 8, 6, 3, 0, 0, 5},
        {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
        {1, 3, 0, 0, 0, 0, 2, 5, 0},
        {0, 0, 0, 0, 0, 0, 0, 7, 4},
        {0, 0, 5, 2, 0, 6, 3, 0, 0} };

        solve_sudoku(sudoku, 0, 0);
    }
}
