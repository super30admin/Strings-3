import java.util.*;

/*Approach: 
1. We use a stack to maintain the results of the operations performed so far
2. We use a variable to store the last operator we came accross. It is initialised to '+' in the beginning
3. We use a variable to store the number computed so far (which is pushed to the stack)
4. In the end, we empty the stack and add up all the values it has

"3-2+6/3*2"

    num              lastOperator
     0                    +
     3                    +       
 -   3                    +         ->  push 3 to stack, reset num = 0, lastOperator = '-'. Stack: [3].
 2   0                    -         
 +   2                    -         -> -2 is pushed to stack, reset num = 0, lastOperator = '+'. Stack: [-2,3].
 6   0                    +
 /   6                    +         -> 6 is pushed to stack, reset num = 0, lastOperator = '/'. Stack: [6,-2,3].
 3   0                    /
 *   3                    /         -> 6 is popped from stack, divided by num, result (2) is stored back on to the stack. Reset num = 0, lastOperator = '*'. Stack: [2,-2,3].
 2   0                    *
     2                    *         -> 2 is popped, multiplied with num, result (4) is stored back on to the stack. Stack: [4,-2,3]
    
Note: 
1. Digit has to be processed first, because the last element is to be processed in the operator handling if, so the last number read should be present in the num
2. These are not handled with if, else. But with if, because you want to deal with num immedtiately after it is set.

Time complexity: O(N)
Space complexity: O(numbers in string at max) for stack 
*/


public class BasicCalculator {
    Stack<String> stack = new Stack<>();
    int num = 0; char lastOperator = '+'; int result=0;
    public int calculate(String s) {
        for(int i=0; i<= s.length()-1; i++)
        {
            char c = s.charAt(i);
            //ignore 
            if(Character.isDigit(c)) //Digit. Convert char into a int and push it to the stack.
                num = num*10+(c-'0');
            else if((c == '+' || c == '-' || c == '/' || c == '*' || c ==')' || c == '(') || i==s.length()-1) //operator or last num
            {   
                if(lastOperator=='+')
                {
                    stack.push(String.valueOf(num));
                }
                else if(lastOperator=='-')
                {
                    stack.push(String.valueOf(-num));
                }
                else if(lastOperator=='*')
                {
                    String num1 = stack.pop();
                    stack.push(String.valueOf(Integer.parseInt(num1)*num));
                }
                else if(lastOperator=='/')
                {
                    String num1 = stack.pop();
                    stack.push(String.valueOf(Integer.parseInt(num1)/num));
                }
                
                //reset num and update lastOperator
                num = 0;
                lastOperator = c;
                
                if(c=='(')
                {
                    stack.push(String.valueOf(c));
                    lastOperator = '+';
                }
                if(c==')')
                {
                    lastOperator = '+';
                    int sum = 0;
                    while(stack.pop()!="(")
                    {
                        sum += Integer.parseInt(stack.pop());
                    }
                    stack.push(String.valueOf(sum));
                }
            }  
            else //in case of spaces
                continue;
        }
        while(!stack.isEmpty())
        {
            result+=Integer.parseInt(stack.pop());
        }
        return result;
    }
}
