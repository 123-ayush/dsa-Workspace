import java.util.*;

public class diagonalSum {

    public static int diagonal(int arr[][]){
        int sum = 0;
        int len = arr[0].length;
           
        for(int i = 0; i<arr.length; i++){
            for(int j = 0; j<arr[0].length; j++){
                if(i == j || i+j+1 == len){ 
                    sum+=arr[i][j];
                }
            }
        }

        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter No. of rows: ");
        int r = sc.nextInt();

        System.out.print("Enter No. of cols: ");
        int c = sc.nextInt();


        int arr[][] = new int[r][c];

        System.out.print("Enter all the elements: ");
        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.print("Diagonal Sum of matrix is: " + diagonal(arr));

        sc.close();

        return;
    }
}
