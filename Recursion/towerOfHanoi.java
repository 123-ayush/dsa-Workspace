public class towerOfHanoi {
    public static int TOH(int n, String src, String helper, String dest){
        if(n == 1){
            System.out.println("Transfer disk " + n + " from " + src + " to " + dest);
            return 1;
        }

        int help = TOH(n-1, src, dest, helper);
        System.out.println("Transfer disk " + n + " from " + src + " to " + dest);
        int des = TOH(n-1, helper, src, dest);

        return help + 1 + des; // here 1 is added for moving 1 last disk from src to dest
    }
    public static void main(String[] args) {
        int n = 3;

        System.out.println(TOH(n, "S", "H", "D"));
    }
}
