import java.util.Scanner;
public class BasicCalculatorII_NoStack {

        // NO STACK APPROACH - O(N) TIME - O(1) SPACE

        public int calculate(String s) {

            int n = s.length();

            if(n == 0) return 0;

            // initial conditions
            int lastNum = 0;
            char lastSign = '+';

            // tail will be the latest operational change
            int tail = 0;
            int result = 0;

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

                    // when last sign is a plus, add last number to result and update tail
                    if(lastSign == '+') {

                        result += lastNum;

                        tail = lastNum;
                    }

                    // when last sign is a minus, subtract last number from result and update tail
                    else if(lastSign == '-') {

                        result -= lastNum;

                        tail = -lastNum;
                    }

                    // when last sign is a multiplier, negate last operation and do current operation with existing tail and then update tail
                    else if(lastSign == '*') {

                        result = (result - tail) + (tail * lastNum);

                        tail = tail * lastNum;
                    }

                    // when last sign is a divider, negate last operation and do current operation with existing tail and then update tail
                    else if(lastSign == '/') {

                        result = (result - tail) + (tail / lastNum);

                        tail = tail / lastNum;

                    }

                    // after processing an operator, reset two last parameters
                    // last number becomes zero as the last number is just pushed into stack
                    lastNum = 0;

                    // last sign will be current sign which will be used in future calculation
                    lastSign = curr;

                }
            }
            // output calculated result
            return result;
        }

        public static void main(String[] args) {

            BasicCalculatorII_NoStack obj = new BasicCalculatorII_NoStack();

            Scanner scanner = new Scanner(System.in);

            System.out.println("Expression s: ");

            String s = scanner.nextLine();

            int answer = obj.calculate(s);

            System.out.println("Calculated value of the expression is: " + answer);
        }

}

/*
TIME COMPLEXITY = O(N) - iteration over string
SPACE COMPLEXITY = O(1)
*/