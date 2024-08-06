

public class GridWays {
    public static long findGridWays(int row, int col, int i, int j){
        //target is (row-1, col-1)
        if(i == row - 1 && j == col - 1)
            return 1;
        else if(i == row || j == col) //boundary check condition
            return 0;
        long totalWays = findGridWays(row, col, i, j+1) + findGridWays(row, col, i+1, j);

        return totalWays;
    }
    public static long factorial(int n){
        if(n == 0 || n == 1)
            return 1;
        
        return n*factorial(n-1);
    }
    public static long findGridWaysOpti(int rows, int col){
        long numerator = factorial(rows + col - 2);
        long denominator = (factorial(rows - 1))*(factorial(col - 1));
        long res = numerator/denominator;
        System.out.println("num: "+numerator+"  den: "+denominator);
        return res;
    }
    public static void main(String[] args) {
        // long res = findGridWays((int)Math.pow(10, 2),(int)Math.pow(10, 2) , 0, 0);
        long res = findGridWaysOpti(5, 5);
        System.out.println(res);
    }
}
