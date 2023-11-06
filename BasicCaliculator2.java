class Solution {
    public int calculate(String s) {
        if(s == null) return 0;
        int calc = 0;
        int curr = 0;
        int tail = 0;
        int lastSign = '+';
        for(int i=0; i< s.length(); i++){
            char c = s.charAt(i);
              if(Character.isDigit(c)){
            curr = curr*10 + c - '0';
        }
        if((!Character.isDigit(c) && c != ' ') || i == s.length() - 1){
            if(lastSign == '+'){
                calc += curr;
                tail = curr;
            }
            else if(lastSign == '-'){
                calc -= curr;
                tail = -curr;
            }
            else if(lastSign == '*'){
                calc = calc - tail + (tail * curr);
                tail = tail * curr;
            }
            else{
                calc = calc - tail + (tail / curr);
                tail = tail / curr;
            }
            curr =0;
            lastSign = c;
        }
        
        }
        return calc;
      
    }
}

/**
 * 
 * We will follow the “Expressions and Operators” problem method.
Calculating → Calc, tail values at every digit.
for + Cal  → calc + curr, tail → + curr
For - Cal → calc - curr, tail → - curr
For * Cal → calc-tail + tail * curr, tail * curr

Another method is using stack
First we calculate Curr, and when we hit an expression we put curr inside the stack.
If we get any * or / we process them first bcz they have the highest precedence.





What if you have a bracket 
We should use only integer Stack 
But all the numbers and signs and open brackets inside stack till we get a closed bracket.
If we get a closed bracket calculator the integers inside stack till we get a closed bracket. And adding a sign after the closed bracket.
It's an integer stack so we will put +1 and -1 instead of +,-.
If we get any * or / we process them first bcz they have the highest precedence.
99999 instead of ‘(‘

 * 
 * 
 */