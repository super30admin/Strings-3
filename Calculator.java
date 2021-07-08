//Time Complexity :O(N)
//Space Complexity :O(N)
//Did this code successfully run on Leetcode :yes
//Any problem you faced while coding this :Nope.


//Your code here along with comments explaining your approach

class Calculator {
    public int calculate(String s) {
        if(null == s || 0 == s.length()){return -1;}
        Stack<String> stack = new Stack<>();
        boolean evaluateTop = false;
        int i = 0;
        while(i < s.length()){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                String number = "";
                while(i < s.length() && !isOperator(s.charAt(i))){
                    if(Character.isDigit(s.charAt(i))){
                        number += s.charAt(i);
                    }
                    i++;
                }
                stack.push(number);
                if(i != s.length()){
                    i--;
                }
                if(evaluateTop && !stack.isEmpty() && !stack.peek().equals("*") && !stack.peek().equals("/")){
                evaluateTop = false;
                String right = stack.pop();
                String operator = stack.pop();
                String left = stack.pop();
                Integer res = 1;
                if(operator.equals("*")){
                    res = Integer.valueOf(left)*Integer.valueOf(right);
                    stack.push(""+res);
                }
                if(operator.equals("/")){
                    res = Integer.valueOf(left)/Integer.valueOf(right);
                    stack.push(""+res);
                }
            }
            }else if(isOperator(ch)){
                stack.push(""+ch);
                if(ch == '*' || ch == '/'){
                        evaluateTop = true;
                    }
            }
            i++;
        }
        int result = 0;
        while(!stack.isEmpty()&&stack.size()>1){
                String right = stack.pop();
                String operator = stack.pop();
                if(operator.equals("+")){
                    Integer r = Integer.valueOf(right);
                    result += r;
                }
                if(operator.equals("-")){
                    Integer r = Integer.valueOf(right);
                    result -= r;
                }
        }
        result += Integer.valueOf(stack.peek());
        return result;
    }
    
    private boolean isOperator(char ch){
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }
}