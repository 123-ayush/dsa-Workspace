// time complexity is 2^(n+m); 

public class gridWays {
    public static int ways(int r, int c){
        if(r < 0 || c < 0){
            return 0;
        }

        if(r == 0 && c == 0){
            return 1;
        }

        int up = ways(r-1, c);
        int side = ways(r, c-1);

        return up+side;
    }    

    public static void main(String[] args) {
        int r = 2, c = 2;
        System.out.println("Ways: " + ways(r-1, c-1));
        return;
    }
}

// to deduce the time complexity to linear O(n+m), use formula = ((n-1+m-1)!/((n-1)! * (m-1)!))
