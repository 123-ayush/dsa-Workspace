
public class firstOccurence {
    public static int find(int[] arr, int idx, int key){
        if(idx == arr.length){
            return -1;
        }

        if(arr[idx] == key){
            return idx;
        }

        return find(arr, idx+1, key);
    }

    public static int findLast(int[] arr, int idx, int key){
        if(idx == -1){
            return -1;
        }

        if(arr[idx] == key){
            return idx;
        }

        return findLast(arr, idx-1, key);
    }
    public static void main(String[] args) {
        int[] arr = {8,4,7,3,1,56,8,2,2,6,8};
        //           0,1,2,3,4, 5,6,7,8,9,10

        System.out.println(findLast(arr, ((arr.length)-1), 2));
        
        return;
    }
}
