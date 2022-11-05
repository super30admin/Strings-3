//Time: O(n)
//Space: O(n)
//Stack
// class Solution {
//     public int calculate(String s) {
//         if(s == null || s.length() == 0)
//             return 0;
//         int num = 0;
//         Stack<Integer> st = new Stack<>();
//         int calc = 0;
//         char lastSign = '+';
//         s = s.trim();
        
//         for(int i = 0; i < s.length(); i++){
//             char c = s.charAt(i);
//             if(Character.isDigit(c)){
//                 num = num * 10 + c - '0';
//             }
//             if((!Character.isDigit(c) && c != ' ') || (i == s.length() - 1)){
//                 if(lastSign == '+'){
//                     st.push(num);
//                 }
//                 else if(lastSign == '-'){
//                     st.push(-num);
//                 }   
//                 else if(lastSign == '*'){
//                     st.push(st.pop() * num);
//                 }
//                 else{
//                     st.push(st.pop() / num);
//                 }
//                 lastSign = c;
//                 num = 0;
//             }
//         }
//         while(!st.isEmpty())
//             calc = calc + st.pop();
//         return calc;
        
//     }
// }

//Time: O(n)
//Space: O(1)
class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int num = 0;
        int calc = 0;
        int tail = 0;
        char lastSign = '+';
        s = s.trim();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            }
            if((!Character.isDigit(c) && c != ' ') || (i == s.length() - 1)){
                if(lastSign == '+'){
                    calc = calc + num;
                    tail = +num;
                }
                else if(lastSign == '-'){
                    calc = calc - num;
                    tail = -num;
                }   
                else if(lastSign == '*'){
                    calc = calc - tail + (tail * num);
                    tail = tail * num;
                }
                else{
                    calc = calc - tail + (tail / num);
                    tail = tail / num;
                }
                lastSign = c;
                num = 0;
            }
        }
        return calc;
        
    }
}
