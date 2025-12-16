// no of permutations for n ele is n!

public class findPermutations {
    public static void permutations(StringBuilder str, StringBuilder res){
        if(str.length() == 0){
            System.out.println(res);
            return;
        }

        for(int i = 0; i<str.length(); i++){
            char c = str.charAt(i);
            res.append(c);
            str.deleteCharAt(i);

            permutations(str, res);

            res.deleteCharAt(res.length()-1);
            str.insert(i, c);
        }
    }
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("abc");
        permutations(str, new StringBuilder(""));
    }
}
