// Time complexity - 0(n)
// space complexity - 0(n)
// coce successfully executed in leetcode

class Solution {
    public int calculate(String s) {
    if (s == null || s.length() == 0) return 0;
        int lastsign = '+';
        int num =0;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            }
            if((!Character.isDigit(c) && c!=' ') || i==s.length()-1){
                if(lastsign == '+') st.push(num);
                if(lastsign == '-') st.push(-num);
                if(lastsign == '*') st.push(st.pop()*num);
                if(lastsign == '/') st.push(st.pop()/num);
                lastsign = c;
                num =0;
            }
        }
        int sum =0;
        while(!st.isEmpty()){
            sum = sum + st.pop();
        }
        return sum;
    }
}