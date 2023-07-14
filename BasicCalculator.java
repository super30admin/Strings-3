class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        s = s.trim();
        Stack<Integer> st = new Stack<>();
        char lastSign = '+'; int curr = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                curr = curr * 10 + c - '0';
                if(i == s.length() - 1){
                    if(lastSign == '+') st.push(curr);
                    else st.push(-curr);
                }
            } else if(c == '+' || c == '-'){
                if(lastSign == '+') st.push(curr);
                else st.push(-curr);
                curr = 0; lastSign = c;
            } else if(c == '('){ //(1+(-4+5+2)-3)
                if(lastSign == '+')st.push(1);
                else st.push(-1);
                st.push(Integer.MAX_VALUE);
                curr = 0; lastSign = '+';
            } else if(c == ')'){
                if(lastSign == '+') st.push(curr);
                else st.push(-curr);
                int interResult= 0;
                while(st.peek() != Integer.MAX_VALUE){
                    interResult += st.pop();
                }
                st.pop(); // +1 -1
                interResult = interResult * st.pop();
                st.push(interResult);
                curr = 0; lastSign = '+';
            }
        }
        int result = 0;
        while(!st.isEmpty()){
            result += st.pop();
        }
        return result;
    }
}
// class Solution {
//     public int calculate(String s) {
//         Stack<Integer> st = new Stack<>();
//         s.trim();
//         int result = 0;
//         char lastSign = '+'; int curr = 0;
//         for(int i=0;i<s.length();i++){
//             if(s.charAt(i)!=' ' && s.charAt(i) == '('){
//                 if(i==0 || s.charAt(i-1) == '+'){
//                     st.push(1);
//                 }else if(s.charAt(i-1) == '-'){
//                     st.push(-1);
//                 }
//                 st.push(Integer.MAX_VALUE);
//             }
//             if(s.charAt(i)!=' ' && Character.isDigit(s.charAt(i))){
//                 curr = curr*10 + s.charAt(i) - '0';
//                 if(i == s.length() - 1){
//                     if(lastSign == '+') st.push(curr);
//                     else st.push(-curr);
//                 }
//             } else if(s.charAt(i) == '+' || s.charAt(i) == '-'){
//                 if(lastSign == '+') st.push(curr);
//                 else st.push(-curr);
//                 curr = 0; lastSign = s.charAt(i);
//             }
//             if(s.charAt(i)!=' ' && s.charAt(i)==')'){
//                 int res = 0;
//                 while(st.peek()!=Integer.MAX_VALUE){
//                     res = res + st.pop();
//                 }
//                 st.pop();
//                 res = res*st.pop();
//                 st.push(res);
//             }
//             System.out.println(st);
//         }
//         while(!st.isEmpty()){
            
//             result = result + st.pop();
//         }
//         return result;
//     }
// }