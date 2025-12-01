import java.util.*;

public class spiralMatrix {

    public static void spiral(int arr[][], int r, int c){
        int left = 0, right = c-1, top = 0, bottom = r-1;

        while(top<bottom && left<right){
            for(int i = left; i<=right; i++){
                System.out.print(arr[top][i] + " ");
            }
            top++;

            for(int i = top; i<=bottom; i++){
                System.out.print(arr[i][right] + " ");
            }
            right--;

            for(int i = right; i>=left; i--){
                System.out.print(arr[bottom][i] + " ");
            }
            bottom--;

            for(int i = bottom; i>=top; i--){
                System.out.print(arr[i][left] + " ");
            }
            left++;
        }

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

        System.out.print("Spiral matrix is: ");
        spiral(arr, r, c);

        sc.close();

        return;
    }

}
