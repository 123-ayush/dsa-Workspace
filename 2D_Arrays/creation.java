import java.util.*;

public class creation{

    public static boolean search(int arr[][], int key){
        for(int i = 0; i<arr.length; i++){
            for(int j = 0; j<arr[0].length; j++){
                if (arr[i][j] == key){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();

        int arr[][] = new int[r][c];

        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(search(arr, 5));

        sc.close();

        return;
    }
}
