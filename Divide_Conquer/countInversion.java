public class countInversion{
    public static int count(int[] arr, int st, int mid, int end){
        int num = 0;

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
            if(R[j] < L[i]){
                num+=(l-i);
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

        return num;
    }

    public static int inversion(int[] arr, int st, int end){
        if(st>=end){
            return 0;
        }

        int mid = (st+end)/2;

        int left = inversion(arr, st, mid);
        int right = inversion(arr, mid+1, end);

        return count(arr, st, mid, end) + left + right;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        System.out.println("Count: " + inversion(arr, 0, arr.length-1));
        
        return;       
    }
}