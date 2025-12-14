public class searchInRotatedSorted {
    public static int modifiedSearch(int arr[], int st, int end, int tar){
        if(st>end){
            return -1;
        }

        int mid = (st+end)/2;

        if(arr[mid] == tar){
            return mid;
        }

        if(arr[st] <= arr[mid]){
            if(arr[st]<=tar && tar<=arr[mid]){
                return modifiedSearch(arr, st, mid-1, tar);
            }else{
                return modifiedSearch(arr, mid+1, end, tar);
            }
        }else{
            if(arr[mid]<=tar && tar<=arr[end]){
                return modifiedSearch(arr, mid+1, end, tar);
            }else{
                return modifiedSearch(arr, st, mid-1, tar);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int tar = 1;

        System.out.println(modifiedSearch(arr, 0, arr.length-1, tar));
    }
}
