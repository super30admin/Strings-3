// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// similar to evaluate expression in backtracking problem set
// maintain sum, prevNum, curNum, curOp, modify sum according to what the curOp is 

class Solution {
    
    int sum = 0;
    int curNum = 0;
    int prevNum = 0;
    char curOp = ' ';    
    
    public int calculate(String s) {
        int i=0;
    
        while(i<s.length()){
            if(Character.isWhitespace(s.charAt(i))){
                i++;
            }
            else if(Character.isDigit(s.charAt(i))){
                curNum = 0;
                while(i<s.length() && Character.isDigit(s.charAt(i))){
                    curNum = curNum*10 + Character.getNumericValue(s.charAt(i));
                    i++;
                }
                
                updateSum();
            }
            else if(s.charAt(i)=='*'){
                curOp = '*';
                i++;
            }
            else if(s.charAt(i)=='/'){
                curOp = '/';
                i++;
            }
            else if(s.charAt(i)=='+'){
                curOp = '+';
                i++;
            }
            else if(s.charAt(i)=='-'){
                curOp = '-';
                i++;
            }
        }
        
        return sum;
    }
    
    private void updateSum(){
        if(curOp=='*'){
            sum = sum - prevNum;
            sum = sum + prevNum*curNum;
            prevNum = prevNum*curNum;
        }
        else if(curOp=='/'){
            sum = sum - prevNum;
            sum = sum + prevNum/curNum;
            prevNum = prevNum/curNum;
        }
        else if(curOp=='+'){
            sum = sum + curNum;
            prevNum = curNum;
        }
        else if(curOp=='-'){
            sum = sum - curNum;
            prevNum = -curNum;
        }
        else if(curOp==' '){
            sum = sum + curNum;
            prevNum = curNum;
        }
    }
}