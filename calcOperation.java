//TC: O(n)
//SC: O(num of operators)
class Solution {
    public int calculate(String s) {
        if(s.length()==0)
            return 0;
        Stack<Integer> stack = new Stack<Integer>();
        char sign = '+';
        int num=0;
        for(int i=0;i<s.length();i++)
        {
            if(Character.isDigit(s.charAt(i)))  //Traversing to each char by char of the given string
            {
                num = num*10+(s.charAt(i)-'0'); //Getting the number storing in num var.
            }
            else if(s.charAt(i)==' ')       //if the sign is found, push the num to stack, if sign is + or -
               continue;        //if sign is * or / perform the operation with popped value of nums and add the result to stack
            else
            {                       //Once done get the sum of all values of the stack
                if(sign=='*')
                    stack.add(stack.pop()*num);
                else if(sign=='/')
                    stack.add(stack.pop()/num);
                else if(sign=='-')
                    stack.add(0-num);
                else
                    stack.add(num);                       
                num = 0;
                sign = s.charAt(i);
            } 
        }
        if(sign=='*')
            stack.add(num*stack.pop());
        else if(sign=='/')
            stack.add(stack.pop()/num);
        else if(sign=='-')
            stack.add(0-num);
        else
            stack.add(num);
        int result = 0;
        while(!stack.isEmpty()) 
        {
            result+=stack.pop();
        }
        return result;
    }
}