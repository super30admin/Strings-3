class BasicCalculator  {
    public int calculate(String s) {
        Stack<Integer> myStack = new Stack<>();
        char lastSign = '+';
        int currNum = 0;
        for(int i=0; i<s.length(); i++){
            char currChar = s.charAt(i);
            if(Character.isDigit(currChar)){
                currNum = currNum*10+(currChar-'0');
            }

            if((!Character.isDigit(currChar) && currChar !=' ')|| i == s.length()-1){
                if(lastSign == '+'){
                    myStack.push(currNum);
                }

                else if(lastSign == '-'){
                    myStack.push(-currNum);
                }

                else if(lastSign == '*'){
                    myStack.push(myStack.pop() * currNum);
                }

                else if(lastSign == '/'){
                    myStack.push(myStack.pop() / currNum);
                }
            currNum = 0;
            lastSign = currChar;
            }
        }
        int res = 0;
        while(!myStack.isEmpty()){
            res = res+ myStack.pop();
        }
        return res;
    }
}


class Solution {
    public int calculate(String s) {
        int calculated = 0;
        int tail =0;
        char lastSign = '+';
        int currNum = 0;

        for(int i=0; i< s.length(); i++){
            char currChar = s.charAt(i);
            if(Character.isDigit(currChar)){
                currNum = currNum*10 +(currChar - '0');
            }

            if((!Character.isDigit(currChar) && currChar != ' ') || i == s.length()-1){
             if(lastSign == '+'){
                calculated = calculated + currNum;
                tail = currNum;
            }
            else if(lastSign == '-'){
                calculated = calculated - currNum;
                tail = -currNum;
            }
            else if(lastSign == '*'){
                calculated = (calculated - tail)+(tail*currNum);
                tail = tail * currNum;
            }
            else if(lastSign == '/'){
                calculated = (calculated - tail)+(tail/currNum);
                tail = tail / currNum;
            }
            currNum = 0;
            lastSign = currChar;
         }
        }
        return calculated;
    }
}