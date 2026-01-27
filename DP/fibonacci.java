public class fibonacci {
    public static int fibRecur(int n, int f[]){
        if(n == 1 || n == 0){
            return n;
        }

        if(f[n] != 0) {
            return f[n];
        }

        f[n] = fibRecur(n-1, f) + fibRecur(n-2, f);

        return f[n];
    }

    public static int fibIter(int n, int f[]){
        f[0] = 0;
        f[1] = 1;

        for(int i = 2; i<=n; i++){
            f[i] = f[i-1] + f[i-2];
        }

        return f[n];
    }
    public static void main(String[] args){
        int n = 6;
        int f[] = new int[n+1];

        System.out.println(fibIter(n, f));

        return;
    }
}
