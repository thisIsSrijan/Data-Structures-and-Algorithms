// x<<i => x shifted left by i bits 
// x>>i => x shifted right by i bits
// x&y => bitwise and of x and y
// x|y => bitwise or of x and y
// x^y => bitwise xor of x and y
// ~x => bitwise not of x
// index starts from right to left

//bitmask: 1<<i => 1 shifted left by i bits

public class Bit {
    public static int getBit(int n, int i){ //get ith bit of n
        return (n & (1<<i))!=0?1:0; //left shift 1 by i and do bitwise and with n
    }

    public static int setBit(int n, int i){ //set ith bit of n to 1
        return n | (1<<i); //left shift 1 by i and do bitwise or with n
    }

    public static int clearBit(int n, int i){ //clear ith bit of n
        return n & ~(1<<i); //left shift 1 by i, do bitwise not of bitmask and then do bitwise and with n
    }

    public static int updateBit(int n, int i, int v){ //update ith bit of n to v
        //clear ith bit of n and then set ith bit to v
        return (n & ~(1<<i)) | (v<<i); //left shift 1 by i, do bitwise not, do bitwise and with n, left shift v by i, do bitwise or with n
    }
    public static void main(String[] args) {
        String bing = "1010";
        int n = Integer.parseInt(bing, 2);
        System.out.println(n); //1
    }
}
