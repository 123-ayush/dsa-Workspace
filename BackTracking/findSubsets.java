// if we have n ele, then the number of subsets are 2^n;

public class findSubsets {
    public static void subsets(String str, String res, int idx){
        if(idx == str.length()){
            System.out.println(res);
            return;
        }

        subsets(str, res+str.charAt(idx), idx+1);
        
        subsets(str, res, idx+1);
    }
    public static void main(String[] args) {
        String st = "abc";
        subsets(st, "", 0);
        return;
    }
}
