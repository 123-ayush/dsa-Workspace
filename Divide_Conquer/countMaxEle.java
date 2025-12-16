public class countMaxEle {
    public static int count(int arr[], int num, int l, int r){
        int count = 0;

        for(int i = l; i<r; i++){
            if(arr[i] == num){
                count++;
            }
        }

        return count;
    }

    public static int majorityEle(int arr[], int st, int end){
        if(st == end){
            return arr[st];
        }

        int mid = (end+st)/2;

        int left = majorityEle(arr, st, mid);
        int right = majorityEle(arr, mid+1, end);

        if(left == right){
            return left;
        }

        int leftCount = count(arr, left, st, end);
        int rightCount = count(arr, right, st, end);

        return leftCount > rightCount ? left : right;
    }

    public static void main(String[] args) {
        int arr[] = {2,2,1,1,1,2,2};
        System.out.println(majorityEle(arr, 0, arr.length-1));
        return;
    }
}
