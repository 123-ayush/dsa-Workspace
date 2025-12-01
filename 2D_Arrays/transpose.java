import java.util.*;

public class transpose {

    public static void trans(int arr[][], int r, int c){
        int res[][] = new int[c][r];

        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                res[j][i] = arr[i][j];
            }
        }

        for(int i = 0; i<c; i++){
            for(int j = 0; j<r; j++){
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
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

        trans(arr, r, c);

        sc.close();

        return;
    }
}
