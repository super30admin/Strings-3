class Solution {// time of O(N) space of O(N)
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        char sign = '+';
        int num = 0;
        
        while(idx < s.length()){
            char c = s.charAt(idx);
            // is it a digit 
            {
                if(Character.isDigit(c)){
                    num = num*10 + (c -'0');
                }
                if(!Character.isDigit(c) && c != ' ' || idx == s.length() -1){
                    if(sign =='+')
                        stack.push(num);
                    else if(sign == '-')
                        stack.push(-num);
                    else if(sign == '*'){
                        int last = stack.pop();
                        stack.push(num*last);
                    }else{
                        int last = stack.pop();
                        stack.push(last/num);
                    }
                    num = 0;
                    sign = c;  
                }
                idx++;
            }
        }
        int result = 0;
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }
}