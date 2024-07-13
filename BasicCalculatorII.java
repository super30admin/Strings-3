import java.util.Stack;

//Time Complexity : O(l) where l is the length of the input string
// Space Complexity : O(1) as no auxiliary space is used.
// Did this code successfully run on Leetcode :yes
public class BasicCalculatorII {

    public int calculate(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        if(s.length() == 1){
            return s.charAt(0)-'0';
        }

        int currentNumber = 0;
        char lastOperator = '+';
        int calculatedValue = 0;
        int tail = 0;

        for(int i=0; i<s.length(); i++){
            Character currentChar = s.charAt(i);
            if(Character.isDigit(currentChar)){
                currentNumber = currentNumber * 10 + (currentChar-'0');
            }
            if((!Character.isDigit(currentChar) && currentChar != ' ') || i == s.length()-1){
                if(lastOperator =='+'){
                    calculatedValue += currentNumber;
                    tail = currentNumber;
                }else if(lastOperator =='-'){
                    calculatedValue -= currentNumber;
                    tail = -currentNumber;
                }else if(lastOperator =='*'){
                    calculatedValue = calculatedValue - tail + (tail * currentNumber);
                    tail = tail * currentNumber;
                }else if(lastOperator =='/'){
                    calculatedValue = calculatedValue - tail + (tail / currentNumber);
                    tail = tail / currentNumber;
                }
                currentNumber= 0;
                lastOperator = currentChar;
            }
        }
        return calculatedValue;
    }



    //Time Complexity : O(l) where l is the length of the input string
    // Space Complexity : O(l) where l is the length of the input string
    // Did this code successfully run on Leetcode :yes
    public int calculateBruteForce(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        if(s.length() == 1){
            return s.charAt(0)-'0';
        }
        Stack<Integer> numberStack = new Stack<>();
        int currentNumber = 0;
        char currentOperator = '+';
        for(int idx=0; idx<s.length(); idx++){
            Character currentChar = s.charAt(idx);
            if(Character.isDigit(currentChar)){
                currentNumber = currentNumber * 10 + (currentChar - '0');
            }
            if((!Character.isDigit(currentChar) && currentChar != ' ') || idx == s.length()-1){
                if(currentOperator == '*'){
                    numberStack.push(numberStack.pop()*currentNumber);
                }else if(currentOperator == '/'){
                    numberStack.push(numberStack.pop()/currentNumber);
                }else if(currentOperator == '-'){
                    numberStack.push(-currentNumber);
                }else if(currentOperator == '+'){
                    numberStack.push(currentNumber);
                }
                //reset the currentNumber and currentOperator
                currentOperator = currentChar;
                currentNumber = 0;
            }
        }

        int result = 0;
        while(! numberStack.isEmpty()){
            result += numberStack.pop();
        }
        return result;
    }
}
