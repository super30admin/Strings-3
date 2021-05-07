//Time Complexity : O(n)
//Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
// Your code here along with comments explaining your approach
class Solution {
    public int calculate(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int num=0,result=0;
        Character lastsign = '+';
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            //if the character is a number then asign to num
            if(Character.isDigit(c)){
                num = num*10+c - '0';//sub by string 0 to get the numerical value of the string
            }
            //if operator or last element
            if((!Character.isDigit(c)&&c!=' ')||i==s.length()-1){
                if(lastsign == '+'){
                    stack.push(num);
                }
                else if(lastsign == '-'){
                    stack.push(-num);
                }
                //if the operator is * or '/' then pop the element from the stack , perform the operation and then push the result on to the stack to maintain the BODMAS precedence
                else if(lastsign == '*'){
                    stack.push(stack.pop() * num);
                }
                else{
                    stack.push(stack.pop() / num);
                }
                //reset the num and update the lastsign to the current operator
                num = 0;
                lastsign = c;
            }
        }
        //add the elements remaing in the stack
        while(!stack.isEmpty()){
            result = result + stack.pop();
        }
        return result;
    }
}