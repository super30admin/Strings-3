/*Time COmplexity : O(N)
SPace COmplexity : O(1)
*/
class Solution {
    public int calculate(String s) {
        if(s==null || s.length() == 0){
            return 0;
        }
        Stack<Integer> st = new Stack<>();
        int num=0;
        int ans=0;
        char lastSign='+';
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num*10 + c-'0';
            }
            if(!Character.isDigit(c) && c != ' ' || i==s.length()-1){
                if(lastSign == '+'){
                    st.push(num);
                }else if(lastSign == '-'){
                    st.push(-num);
                }else if(lastSign == '*'){
                    st.push(st.pop()*num);
                }else if(lastSign == '/'){
                    st.push(st.pop()/num);
                }
                lastSign = c;
                num = 0;
            }
        }
        int re = 0;
        while(!st.isEmpty()){
            re += st.pop();
        }
        return re;
    }
}