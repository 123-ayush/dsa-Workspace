public class powerN {
    public static int power(int x, int n){
        if(n == 0){
            return 1;
        }

        return x*power(x,n-1);
    }

    public static int powerOP(int x, int n){ //(log(n))
        if(n == 1){
            return x;
        }

        if(n%2 == 0){
            return powerOP(x, n/2)*powerOP(x, n/2);
        }else{
            return x * (powerOP(x, n/2)) * (powerOP(x, n/2));
        }
    }

    public static void main(String[] args) {
        System.out.println(powerOP(2, 10));
        return;
    }
}
