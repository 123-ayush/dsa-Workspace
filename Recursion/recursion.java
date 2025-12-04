// What is Recursion?
// Recursion is a method of solving a computational problem where the
// solution depends on solutions to smaller instances of the same problem.

// important steps to make recursive func:
    //1. declare a base case
    //2. do the work what we want
    //3. do the inner call

public class recursion {
    public static void printInDecOrder(int n){
        if(n == 0){
            System.out.println(0);
            return;
        }


    }
    public static void main(String[] args) {
        printInDecOrder(5);
        return;
    }
}

/*
Stack overflow:
    if we dont have any kind of base case then it happens due to many calls
*/