// Time Complexity : 0(n) where n is length of the string
// Space Complexity : 0(n) for stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class BasicCalculator {
    public int calculate(String s) {
        if(s.length() == 0)
            return 0;
        //initialize stack for putting numbers
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char operation = '+';
        //iterating through the string
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            //if character is number
            if(Character.isDigit(c)){
                num = (num * 10) + Character.getNumericValue(c);
            }
            //if number is not number
            if((!Character.isDigit(c) && c != ' ') || i==s.length()-1){
                if(operation == '-'){
                    stack.push(-num);
                }else if(operation == '+'){
                    stack.push(num);
                }else if(operation == '*'){
                    stack.push(stack.pop() * num);
                }else if(operation == '/'){
                    stack.push(stack.pop() / num);
                }
                operation = c;
                num = 0;
            }
        }

        //calculating the final result by adding all results
        int result = 0;
        while(stack.size() != 0){
            result += stack.pop();
        }

        return result;
    }
}