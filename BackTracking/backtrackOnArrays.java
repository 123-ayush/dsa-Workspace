public class backtrackOnArrays {
    public static void assign(int arr[], int idx){
        if(idx == arr.length){
            return;
        }

        arr[idx] = idx+1;

        assign(arr, idx+1);

        arr[idx] -= 2;
    }
    public static void main(String[] args) {
        int arr[] = new int[5];
        assign(arr, 0);

        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        
        return;
    }    
}
