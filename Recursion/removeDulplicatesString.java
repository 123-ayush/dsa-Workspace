public class removeDulplicatesString {
    public static String remove(String st, int idx) {
        if(st.length() == 0 || idx == st.length()){
            return "";
        }

        String res = "";
        int n = st.substring(0, idx).indexOf(st.charAt(idx));
        if(n == -1){
            return res + (st.charAt(idx)) + remove(st, idx+1);
        }else{
            return res + remove(st, idx+1);
        }
    }
    public static void main(String[] args) {
        String st = "aa";
        System.out.println(remove(st, 0));

        return;
    }
}
