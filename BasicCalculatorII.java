import java.util.Stack;

/*
Time Complexity: O(N), N is the length of given string
Space Complexity: O(N), as we are using stack
Run on leetcode: yes
Any difficulties: no

Approach:
1. Using stack to push numbers until I encounter * or / as according to BODMAS rule* and / have higher priority than + or -
 */
public class BasicCalculatorII {
    public static int basicCalculatorII(String s){
        if(s == null){
            return 0;
        }

        Stack<Integer> numberStack = new Stack<>();
        char sign = '+';
        int i = 0;
        int temp = 0;
        while(i<s.length()){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                temp = temp*10+ (c-'0');
            }
            if(!Character.isDigit(c) && c!= ' ' || i == s.length()-1){
                if(sign == '+'){
                    numberStack.push(+temp);
                }else if(sign == '-'){
                    numberStack.push(-temp);
                }else if(sign == '*' || sign == '/'){
                    int num = numberStack.pop();
                    if(sign == '*'){
                        numberStack.push(+(num*temp));
                    }else{
                        numberStack.push(+(num/temp));
                    }
                }
                sign = c;
                temp = 0;
            }
            i++;
        }

        int calculations = 0;
        while(!numberStack.isEmpty()){
            calculations+= numberStack.pop();
        }
        return calculations;
    }
    public static void main(String[] args){
        System.out.println("Basic Calculator: "+ basicCalculatorII("3+2*2"));
        System.out.println("Basic Calculator: "+ basicCalculatorII(" 3/2 "));
        System.out.println("Basic Calculator: "+ basicCalculatorII(" 3+5 / 2 "));
    }
}
