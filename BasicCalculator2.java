import java.util.Stack;

public class BasicCalculator2 {
    //Time complexity: O(N) length of string
    //Space Complexity O(N) - length of string in worst case
    public int calculate(String s) {
        s.trim();
        Stack<Integer> stack = new Stack<>();
        char lastExp = '+';
        int current = 0;
        for(int i =0; i< s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                current = current*10+ (ch - '0');
            }
            if((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1){
                if(lastExp == '+'){
                    stack.push(current);
                }else if(lastExp == '-'){
                    stack.push(current * -1);
                }else if(lastExp == '*'){
                    stack.push(stack.pop()* current);
                }else if(lastExp == '/'){
                    stack.push(stack.pop()/ current);
                }

                current = 0;
                lastExp = ch;
            }
        }
        current = 0;
        while(!stack.isEmpty()){
            current = current + stack.pop();
        }

        return current;

    }
}
