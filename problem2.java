// 227 Basic Calculator II
// Solved on Leetcode  
// Time Complexity : O(n)
// Space Complexity : O(n)


class Solution {
    public int calculate(String s) {
        char lastSign='+';
        Stack<Integer> stack = new Stack();
        int num=0;
        
        for(int i=0;i<s.length();i++){
            
            char ch= s.charAt(i);
            
            if(Character.isDigit(ch)){
                num=num*10+ ch-'0';
            }
            if(ch =='*' || ch =='+' || ch =='-' || ch =='/' || i==s.length()-1){
                
                if(lastSign=='+'){
                    stack.push(num);
                }
                if(lastSign=='-'){
                    stack.push(num*(-1));
                }
                if(lastSign=='*'){
                    stack.push(stack.pop()*num);
                }
                if(lastSign=='/'){
                    stack.push(stack.pop()/num);
                }
                num=0;
                lastSign=ch;
            }
        }
        while(!stack.isEmpty()){
                num=num+stack.pop();
            }
        
        return num;
    }
}