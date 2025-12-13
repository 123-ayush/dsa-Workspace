public class binaryStrings {
    public static void str(StringBuilder st, int n, int idx){
        if(idx == n){
            System.out.println(st);
            return;
        }

        if(idx == 0 || st.charAt(idx-1) == '0'){
            st = st.append("0");
            str(st, n, idx+1);
            st = st.deleteCharAt(st.length()-1);
            
            st = st.append("1");
            str(st, n, idx+1);
            st = st.deleteCharAt(st.length()-1);
        }else{
            if(st.charAt(idx-1) == '1'){
                st = st.append("0");
                str(st, n, idx+1);
                st = st.deleteCharAt(st.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        str(new StringBuilder(""), 5, 0);
        return;
    }
}
