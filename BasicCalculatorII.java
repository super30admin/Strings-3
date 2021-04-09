// Time Complexity :O(n)
// Space Complexity :O(m)-->where m is the height of the stack from m digits in the input string
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach



class Solution {
    public int calculate(String s) {
      //use stack to store the digits from the input string
      Stack<Integer> numStack = new Stack<>();
      int num =0;
      //last sign is the operator seen before any number
      char lastSign = '+';
      
      for(int i=0;i<s.length();i++)
      {
        char c = s.charAt(i);
        //convert to integer
        if(Character.isDigit(c))
        {
          num = num * 10 + (c - '0');
        }
        if(c != ' ' && !Character.isDigit(c) || i == s.length()-1)
        {
          //operator seen before the number is + , add the number to stack
          if(lastSign == '+')
          {
            numStack.push(num);
          }
          //operator seen before the number is + , add the number multiplied by negative -1 to stack
          else if(lastSign == '-')
          {
            numStack.push(num * -1);
          }
          //operator seen before the number is * , multiply the last number with the number at the top in the stack and add the product back to stack
          else if(lastSign == '*')
          {
            int temp = numStack.pop();
            numStack.push(num * temp);
          }
          //operator seen before the number is / , divide the last number with the number at the top in the stack and add the result back to stack
          else if(lastSign == '/')
          {
            int temp = numStack.pop();
            numStack.push(temp / num);
          }
          num = 0;
          //update the lastSign
          lastSign = c;
        }
      }
      int result = 0;
      //in the stack we have all numbers from products , divisions , negative , postive , we just need to add all to get the result
      while(!numStack.isEmpty())
      {
        result+=numStack.pop();
      }
      return result;
    }
}