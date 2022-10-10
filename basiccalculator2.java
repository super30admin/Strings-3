/*
Time Complexity: O(n)
Space Comlexity: O(n)
*/
class Solution {
    public int calculate(String s) {
        
        Stack<Integer> stk = new Stack<>();
        int sum =0;
        char sign ='+';
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                int val=0;
                while(i<s.length()&& Character.isDigit(s.charAt(i))){
                    val = val*10 + (s.charAt(i)-'0');
                    i++;
                }
                i--;
                
                if(sign=='+'){
                    stk.push(val);
                }
                else if(sign=='-'){
                    stk.push(-val);
                }
                else if(sign=='*'){
                    val = val*stk.pop();
                    stk.push(val);
                }
                else if(sign=='/'){
                    val = stk.pop()/val;
                    stk.push(val);
                }
            }
            else if(ch!=' '){
                sign =ch;
            }
        }
        
        while(stk.size()>0){
            sum +=stk.pop();
        } 
        return sum;
    }
}