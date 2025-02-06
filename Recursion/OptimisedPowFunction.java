
public class OptimisedPowFunction {
    public static int calc_power(int x, int n){
        if(n == 0)
            return 1;
        if(n == 1)
            return x;
        
        if(n%2 == 0)
            return (calc_power(x, n/2)*calc_power(x, n/2));
        else
            return (x*calc_power(x, n/2)*calc_power(x, n/2));
    }

    public static int calc_power_optimised(int x, int n){
        if(n == 0)
            return 1;
        if(n == 1)
            return x;
        
        int temp = calc_power_optimised(x, n/2);
        if(n%2 == 0)
            return (temp*temp);
        else
            return (x*temp*temp);
    }

    public static void main(String[] args) {
        System.out.println(calc_power(3, 3));
    }    
}
