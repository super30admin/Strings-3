TC:O(n)
SC:O(n)

Approach: There are two cases for the character in the string, one for number and other for operators.Use stack to store the intermediate results.
When it is number,get the actual value,if it is an operator, according to the last sign, take action. If last sign is + or -, just add the current 
number to the stack.if it is a * or / pop the value in stack, multiply/divide it with the new number and push it back again.

class Solution {
    public int calculate(String s) {

        
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char lastsign = '+';
        
        for(int i=0; i<s.length() ; i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)) num = num*10+ c -'0';
            if(!Character.isDigit(c) && c!= ' ' || i== s.length()-1 ) {
                if(lastsign=='+') stack.push(num);
                if(lastsign=='-') stack.push(-num);
                if(lastsign=='*') stack.push(stack.pop()*num);
                if(lastsign=='/') stack.push(stack.pop()/num);
            lastsign = c;
            num = 0;    
            }
            
        }
        
        int sum =0;
        while(!stack.isEmpty()){
            sum+=stack.pop();
        }
        return sum;
    }
}
