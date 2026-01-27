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
        for(int i = 0; i<=n; i++){
            
        }
        return f[n];
    }
    public static void main(String[] args){
        int n = 6;
        int f[] = new int[n+1];

        System.out.println(fibRecur(n, f));

        return;
    }
}
