// import java.util.*;

public class bit {
    public static int setIthBit(int n, int i){
        int bitMask = 1<<i;
        return n|bitMask;
    }

    public static int getIthBit(int n, int i){
        int bitMask = 1<<i;

        if((n&bitMask) != 0){
            return 1;
        }

        return 0;
    }

    public static int clearIthBit(int n, int i){
        int bitMask = ~(1<<i);
        return n&bitMask;
    }

    public static int updateIthBit(int n, int i){
        if(getIthBit(n, i) == 1){
            return clearIthBit(n, i);
        }else{
            return setIthBit(n, i);
        }
    }

    public static int clearLastIBits(int n, int i){
        int bitMask = (~0)<<i;
        return (n & bitMask);
    }

    public static int clearRangeOfBits(int n, int i, int j){
        int bitMask = ~((~((~0)<<j))<<i);
        return (n & bitMask);
    }

    public static boolean checkNumberIsPowOf2(int n){
        int bitMask = n-1;
        if((n & bitMask) == 0){
            return true;
        }
        return false;
    }

    public static boolean checkOddEven(int n){
        int res = n&1;
        if(res == 1){
            return true;
        }else{
            return false;
        }
    }

    public static void swap(int a, int b){
        a = a^b;
        b = a^b;
        a = a^b;
    }

    public static void main(String[] args) {
        // System.out.println(checkOddEven(5));        

        // System.out.println(getIthBit(11, 4));

        System.out.println(checkNumberIsPowOf2(30));

        return;
    }
}

// Binary operators:
    // or(|), and(&), not(~), xor(^), >>, <<

// 1s complement -> just flip the bits (0-1, 1-0)
// 2s complement -> 1s complement + 1

// MSB(leftmost bit) -> 1 -> means number is negative
                //   -> 0 -> number is positive

// ~5 -> (2s complement of 1s complement of 5) * -1


// toggle 5 bit of any alphabet to convert its case u-l, l-u
