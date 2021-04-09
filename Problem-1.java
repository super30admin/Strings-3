//Time complexity : O(n)
//Space complexity : O(n)

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        
        int num= 0;
        char sign = '+';
        int i=0;
        
        while(i<s.length()){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                num = num*10+(ch-'0');
                
            }
            if((ch != ' ') && !Character.isDigit(ch) || i == s.length() -1){
                if(sign == '+')
                    stack.push(num);
                else if(sign == '-')
                    stack.push(num * -1);
                else if(sign == '*'){
                    int temp = stack.pop();
                stack.push(temp * num);
                }
                else if(sign == '/'){
                    int temp = stack.pop();
                    stack.push(temp/num);
                }
                num =0;
                sign = ch;
            }
            i++;
        }
        
        int output = 0;
        while(!stack.isEmpty()){
            output += stack.pop();
        }
        return output;
    }
}