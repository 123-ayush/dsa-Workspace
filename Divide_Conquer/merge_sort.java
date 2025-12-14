
public class merge_sort {
    public static void merge(int[] arr, int st, int mid, int end){
        int l = mid-st+1;
        int r = end-mid;

        int L[] = new int[l];
        int R[] = new int[r];

        for(int i = 0; i<l; i++){
            L[i] = arr[st+i];
        }

        for(int i = 0; i<r; i++){
            R[i] = arr[mid+i+1];
        }

        int i = 0, j = 0, k = st;
        while(i<l && j<r){
            if(L[i] > R[j]){
                arr[k++] = R[j++];
            }else{
                arr[k++] = L[i++];
            }
        }

        while(i<l){
            arr[k++] = L[i++];
        }

        while(j<r){
            arr[k++] = R[j++];
        }
    }

    public static void msort(int[] arr, int st, int end){
        if(st>=end){
            return;
        }

        int mid = (st+end)/2;

        msort(arr, st, mid);
        msort(arr, mid+1, end);

        merge(arr, st, mid, end);
    }

    public static void printArr(int[] arr) {
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {6, 3, 9, 5, 2, 8, 1, 99, 134, 0, 1342, 322};

        printArr(arr);
        msort(arr, 0, arr.length-1);
        printArr(arr);
        
        return;
    }
}
