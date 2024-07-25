// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;

        int current = 0;
        char lastSign = '+';
        int calculated = 0;
        int tail = 0;

        for(int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                current = current*10 + c-'0';
            }
            if((!Character.isDigit(c) && c != ' ') || i == s.length()-1) {
                if(lastSign == '+') {
                    calculated = calculated + current;
                    tail = +current;
                }else if(lastSign == '-') {
                    calculated = calculated - current;
                    tail = -current;
                }else if(lastSign == '*') {
                    calculated = calculated - tail + tail*current;
                    tail = tail*current;
                }else if(lastSign == '/') {
                    calculated = calculated - tail + tail/current;
                    tail = tail/current;
                }
                lastSign = c;
                current = 0;
            }
        }
        return calculated;
    }
}*/

class Solution {
  public int calculate(String s) {
    if(s == null || s.length() == 0) return 0;

    int current = 0;
    char lastSign = '+';
    Stack<Integer> stack = new Stack<>();

    for(int i = 0; i<s.length(); i++) {
      char c = s.charAt(i);
      if(Character.isDigit(c)) {
        current = current*10 + c-'0';
      }
      if((!Character.isDigit(c) && c != ' ') || i == s.length()-1) {
        if(lastSign == '+') {
          stack.push(+current);
        }else if(lastSign == '-') {
          stack.push(-current);
        }else if(lastSign == '*') {
          stack.push(stack.pop() * current);
        }else if(lastSign == '/') {
          stack.push(stack.pop() / current);
        }
        lastSign = c;
        current = 0;
      }
    }
    int calculated = 0;
    while(!stack.isEmpty()) {
      calculated += stack.pop();
    }
    return calculated;
  }
}