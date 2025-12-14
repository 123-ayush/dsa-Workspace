public class quick_sort {
    public static void qsort(int[] arr, int st, int end){
        if (st >= end) return;

        int pivot = arr[end];
        int i = st - 1;
        for (int j = st; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }

        // place pivot in correct position
        int tmp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = tmp;

        int pidx = i + 1;
        qsort(arr, st, pidx - 1);
        qsort(arr, pidx + 1, end);
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
        qsort(arr, 0, arr.length - 1);
        printArr(arr);
    }
}
