import java.util.*;

public class searchInSorted {

    public static boolean search(int arr[][], int r, int c, int key){
        int i = 0, j = c-1;

        while(i<r && j>=0){
            if(arr[i][j] == key){
                return true;
            }

            if(arr[i][j] > key){
                j--;
            }else{
                i++;
            }
        }

        return false;
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

        System.out.print("search result is: " + search(arr, r, c, 10));

        sc.close();

        return;
    }
}


// three approaches
// 1. Brute force( n^2 )
// 2. row wise binary search if row wise is sorted ( n(log(n)) )
// 3. staircase search (n+m)

    // a. st pt = arr[0][c-1], if cell>key -> move left, else -> move bottom
    // a. st pt = arr[r-1][0], if cell>key -> move top, else -> move right

