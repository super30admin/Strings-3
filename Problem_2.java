//Time Complexity:O(n)
//Space Complexity:O(n)
class Solution {
    public int calculate(String s) {
        if(s==null || s.length()==0) return 0;
        Stack<Integer> st = new Stack<>();
        char lastSign ='+';
        int num=0, res=0;
        for(int i =0;i<s.length();i++){
            char c =s.charAt(i);
            if(Character.isDigit(c)){
                num=num*10+c-'0';
            }
            if((!Character.isDigit(c) && c!=' ') || i==s.length()-1){
                if(lastSign=='+') st.push(num);
                else if(lastSign=='-') st.push(-num);
                else if (lastSign=='*') {
                    st.push(st.pop()*num);
                }
                else {
                    st.push(st.pop()/num);
                }
                num=0;
                lastSign =c;
            }
        }
        while(!st.isEmpty()){
            res+=st.pop();
        }
        return res;
    }
}