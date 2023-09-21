// Time Complexity : O(n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int calculate(String s) {

        int curr =0;
        int calc =0;
        int tail =0;
        char lastSign='+';

        for(int i=0;i<s.length();i++){

            char c = s.charAt(i);
            if(Character.isDigit(c)){
                curr = curr*10+c-'0';
               
            }
            if((!Character.isDigit(c)&&c!= ' ')|| i==s.length()-1){
               
                if(lastSign=='+'){
                    calc = calc + curr;
                    tail = curr;
                }
                else if(lastSign == '-'){
                    calc = calc - curr;
                    tail = -curr;
                }
                else if(lastSign == '*'){
                    
                    calc = calc - tail+ ( tail*curr);
                    tail = tail*curr;
                }
                else {
                    calc = calc - tail+ (tail/curr);
                    tail = tail/curr;
                }
                curr=0;
                lastSign= c;
                 
                
        }
        }
        return calc;
    }
}

// Stack
// Time Complexity : O(n)
// Space Complexity : O(n) --> Stack space 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int calculate(String s) {
        int curr=0;
        int result=0;
        char lastSign ='+';
        Stack<Integer> stack = new Stack<>();

        for(int i=0 ; i<s.length();i++)
        {
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                curr = curr*10+ c-'0';
               System.out.println(curr);   
            }
           if((!Character.isDigit(c) && c!=' ')|| i == s.length()-1){  // since we are lastSign instaed of curr sign we need to do one more time for last value
               System.out.println(i+" "+lastSign);
                if(lastSign == '+'){
                    stack.push(curr);
                }
                else if(lastSign == '-'){
                     stack.push(-curr);
                }
                else if(lastSign == '*'){
                     stack.push(stack.pop()* curr);
                }
                else if(lastSign == '/'){
                    stack.push(stack.pop()/ curr);
                }
                curr=0;
                lastSign=c;
            }
        }
        while(!stack.isEmpty()){
            result+= stack.pop();
        }
        return result;
    }
}