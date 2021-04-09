// Time Complexity : O(n) where n is the length of the String s
// Space Complexity : O(k) since we store only the values after operator-where k is the number of operators in the string
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
       public int calculate(String s) {
           if(s.length() == 0 || s == null) return 0;
           int sum =0;
           char sign = '+';
           int num =0;
           Stack<Integer> st = new Stack<>();
           for(int i=0;i<s.length();i++){
               if(Character.isDigit(s.charAt(i)))
                   num = num*10+Character.getNumericValue(s.charAt(i));
               if(!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length()-1){
                    if(sign == '+')
                        st.push(num);
                   else if(sign == '-')
                       st.push(-num);
                   else if(sign == '*')
                       st.push(st.pop()*num);
                   else if(sign == '/')
                       st.push(st.pop()/num);
                   sign = s.charAt(i);
                   num =0;
               }
           }
           while(!st.isEmpty())
               sum += st.pop();
           
         return sum;
    }
}
