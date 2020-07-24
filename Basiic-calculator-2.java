/*
    Time Complexity : O(N)
    Space Complexity : O(N)
*/

class Solution {
    public int calculate(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        Stack<Integer> st = new Stack<>();
        char lastsign='+'; int num=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + c -'0';
            }
            if((!Character.isDigit(c) && c!=' ')|| i==s.length()-1){
                if(lastsign=='+'){
                    st.push(num);
                } else if(lastsign=='-'){
                    st.push(-num);
                } else if(lastsign=='*'){
                    st.push(st.pop()*num);
                } else if(lastsign=='/'){
                    st.push(st.pop() / num);
                }
                num=0; lastsign=c;
            }
            
        }
        int result=0;
        while(!st.isEmpty()){
            result += st.pop();
        }
        return result;
    }
}

