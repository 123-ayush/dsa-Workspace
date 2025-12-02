// package Bit_Manipulation;

public class fastExpo {
    public static int power(int a, int n) {
        int ans = 1;

        while (n > 0) {
            if ((n & 1) != 0) {
                ans = ans * a;
            }

            a = a * a;
            n = n >> 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(
                power(2, 4));
        return;
    }
}

// take log(n) time...
