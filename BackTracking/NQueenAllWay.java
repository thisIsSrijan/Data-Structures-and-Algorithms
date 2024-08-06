@SuppressWarnings("all")
public class NQueenAllWay {
    
    static int count = 1;

    public static boolean isSafe(char board[][], int row, int col){
        //for 1st queen always return true
        if(row == 0)
            return true;

        //check vertically up
        for (int i = row-1; i >= 0; i--) {
            if(board[i][col] == 'Q')
                return false;
        }

        //check upper left diag
        for(int i = row-1, j = col-1; i>=0 && j>=0; i--, j--){
            if(board[i][j] == 'Q')
                return false;
        }

        //check upper right diag
        for (int i = row-1, j = col+1; i >= 0 && j < board.length; i--, j++) {
            if(board[i][j] == 'Q')
                return false;
        }
        return true;
    }
    public static void printBoard(char board[][]){
        System.out.println("------------chess board (solution "+ count++ +")-----------");
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void NQueens(char board[][], int row){
        if(row == board.length){
            printBoard(board);
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if(isSafe(board, row, i)){
                board[row][i] = 'Q';
                NQueens(board, row+1);
                board[row][i] = 'x'; //backtracking removal of queen
            }
        }
    }
    public static void main(String[] args) {
        char board [][] = new char[5][5];
        //intializing
        for(int i = 0; i < board.length; i++){
            for( int j = 0; j < board.length; j++){
                board[i][j] = 'x';
            }
        }
        NQueens(board, 0);
    }
}
