// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
  public int calculate(String s) {
    if (s == null || s.length() == 0)
      return 0;

    int answer = 0, num = 0;
    char lastsign = '+';
    Stack<Integer> st = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      if (Character.isDigit(c)) {
        num = num * 10 + c - '0';
      }

      if ((!Character.isDigit(c) && c != ' ') || (i == s.length() - 1)) {
        if (lastsign == '+') {
          st.push(num);
        } else if (lastsign == '-') {
          st.push(-num);
        } else if (lastsign == '*') {
          st.push(st.pop() * num);
        } else {
          st.push(st.pop() / num);
        }

        lastsign = c;
        num = 0;
      }
    }
    while (!st.isEmpty()) {
      answer += st.pop();
    }
    return answer;
  }
}