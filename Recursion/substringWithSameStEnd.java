public class substringWithSameStEnd {
    public static int countSubstring(String str, int st, int end){
        int n = str.length();
        if(st == n) return 0;

        if(end == n){
            return countSubstring(str, st+1, st+1);
        }

        int curr = (str.charAt(st) == str.charAt(end)) ? 1 : 0;
        return curr + countSubstring(str, st, end+1);
    }

    public static void main(String[] args) {
        String str = "abcab";
        int count = countSubstring(str, 0, 0);
        System.out.println(count);
    }
}
