import java.util.*;

public class usingArrayList {
    public static class Stack{
        List<Character> stack = new ArrayList<>();

        public void push(char val){
            stack.add(val);
        }

        public boolean empty(){
            return (stack.size() == 0);
        }

        public char pop(){
            if(empty()){
                return '_';
            }

            char top = stack.get(stack.size()-1);
            stack.remove(stack.size()-1);
            return top;
        }

        public char peek(){
            return stack.get(stack.size()-1);
        }

        public void print(){
            for(int i = stack.size()-1; i>=0; i--){
                System.out.println(stack.get(i));
            }
        }

        public boolean validParen(String str){
            char arr[] = str.toCharArray();

            for(char i : arr){
                if(i == '(' || i == '{' || i == '['){
                    push(i);
                }else if(i == ')' || i == '}' || i == ']'){
                    if(empty()){
                        return false;
                    }

                    if(i == ')' && peek() == '('){
                        pop();
                    }else if(i == '}' && peek() == '{'){
                        pop();
                    }else if(i == ']' && peek() == '['){
                        pop();
                    }
                }     
            }

            return empty();
        }

        public boolean duplicateParen(String str){
            char arr[] = str.toCharArray();

            for(char i : arr){
                if(i != ')'){
                    push(i);
                }else{
                    if(i == ')' && peek() == '('){
                        return true;
                    }else{
                        while(peek()!='('){
                            pop();
                        }
                        pop();
                    }
                }     
            }

            return false;
        }
    }

    public static void main(String[] args) {
        Stack st = new Stack();

        String str = "(((a+b)+c))";
        System.out.println(st.duplicateParen(str));

        return;
    }
}
