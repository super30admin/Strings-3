// TC : O(N), N->length of string
// SC : O(N/2) = O(N)
// Did it run successfully on Leetcode? : Yes
class Solution {
    public int calculate(String s) {
        if ( s== null || s.length() == 0)
            return 0;
        int result = 0;
        int n = s.length();
        Stack<Integer> stack = new Stack();
        char lastSign = '+';
        int num = 0;
        for ( int i = 0; i < n; i++)
        {   char c = s.charAt(i);
            if (Character.isDigit(c))
            {
                num = num * 10 + c - '0';
            }
           if((!Character.isDigit(c) && c != ' ') || (i == n-1))
           {
              if (lastSign == '+')
                  stack.push(num);
              else if (lastSign == '-')
                  stack.push(-num);
              else if (lastSign == '*')
              {
                  int poppedNum = stack.pop();
                  stack.push(poppedNum * num);
              }
              else if (lastSign == '/')
              {
                  int poppedNum = stack.pop();
                  stack.push(poppedNum / num);
              }
              lastSign = c;
              num = 0;
           }
        }
        while (!stack.isEmpty())
        {
            result = result + stack.pop();
        }
        return result;
    }
}
