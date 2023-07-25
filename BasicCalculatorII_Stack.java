import java.util.Stack;
import java.util.Scanner;
public class BasicCalculatorII_Stack {

        // STACK APPROACH - O(N)

        public int calculate(String s) {

            int n = s.length();

            if(n == 0) return 0;

            // initial conditions
            int lastNum = 0;
            char lastSign = '+';

            // stack of integers to push and pop digits while calculating
            Stack<Integer> stk = new Stack<>(); // O(N) space

            // iterate over string s
            for(int i = 0; i < n; i++) { // O(N)

                char curr = s.charAt(i);

                // when current character is a digit
                if(Character.isDigit(curr)) {

                    // update current value
                    lastNum = lastNum*10 + curr - '0';
                }

                // when character is not a digit and not an empty space
                if((!Character.isDigit(curr) && curr != ' ') || i == n-1) {

                    // when last sign is a plus, push last number into stack
                    if(lastSign == '+') {

                        stk.push(lastNum);
                    }

                    // when last sign is a minus, push negative of last number into stack
                    else if(lastSign == '-') {

                        stk.push(-lastNum);
                    }

                    // when last sign is a multiplier
                    else if(lastSign == '*') {

                        if(!stk.isEmpty()) {

                            int pop = stk.pop();

                            // multiply last number with the last number in stack
                            stk.push(pop*lastNum);
                        }
                    }

                    // when last sign is a divider
                    else if(lastSign == '/') {

                        if(!stk.isEmpty()) {

                            int pop = stk.pop();

                            // divide last number in stack with the last number outside stack
                            stk.push(pop/lastNum);
                        }
                    }

                    // after processing an operator, reset two last parameters
                    // last number becomes zero as the last number is just pushed into stack
                    lastNum = 0;

                    // last sign will be current sign which will be used in future calculation
                    lastSign = curr;

                }
            }

            int result = 0;

            // after loop, add elements remaining in stack
            while(!stk.isEmpty()) {

                result += stk.pop();
            }

            // output calculated result
            return result;
        }

        public static void main(String[] args) {

            BasicCalculatorII_Stack obj = new BasicCalculatorII_Stack();

            Scanner scanner = new Scanner(System.in);

            System.out.println("Expression s: ");

            String s = scanner.nextLine();

            int answer = obj.calculate(s);

            System.out.println("Calculated value of the expression is: " + answer);
        }

}

/*
TIME COMPLEXITY = O(N) - iteration over string
SPACE COMPLEXITY = O(N) - Stack space
*/