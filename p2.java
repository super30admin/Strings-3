// Time Complexity : O(n)
// Space Complexity : O(n) recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class Solution {
    //Declaring global result
    int result = 0;
    public int calculate(String s) {
        //Calling recursive function
        helper(s, 0, 0, 0, '+');
        return result;
    }

    private void helper(String s, int index, int prev, int curr, char sign){
        //base case where we reach the end of the string, process the last number
        if(index == s.length()) {
            if(sign == '+'){
            result = result + curr;
        }
        else if(sign =='-'){
            result = result - curr;

        }
        else if(sign == '/'){
            result = result - prev + prev/curr;
            

        }
        else if(sign == '*'){
            result = result - prev + prev*curr;
            
        }
        return;
        }


        //logic
        //If it's a space, just move to the next char
        char c = s.charAt(index);
        if(c == ' ') helper(s, index+1, prev, curr, sign);
        //If it's a number, update the curr number
        else if(Character.isDigit(c)){
            curr = curr*10 + c - '0';
            System.out.println(curr);
            helper(s, index+1, prev, curr, sign);
            
        
        }
        //If it's a sign, process the previous number and update the sign 
        else{
            if(sign == '+'){
            result = result + curr;
            
            prev = curr;
            curr = 0;
            helper(s, index+1, prev, curr, c);

        }
        else if(sign =='-'){
            result = result - curr;
            prev = -curr;
            curr = 0;
            helper(s, index+1, prev, curr, c);
        }
        else if(sign == '/'){
            result = result - prev + prev/curr;
            prev = prev/curr;
            curr = 0;
            helper(s, index+1, prev, curr, c);
        }
        else if(sign == '*'){
            result = result - prev + prev*curr;
            
            prev = prev*curr;
            curr = 0;
            helper(s, index+1, prev, curr, c);
        }
        }
        

        
    }
}