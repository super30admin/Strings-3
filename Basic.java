//time complexity-O(n)
//Space complexity-O(n)
//Ran on leetcode-Yes
//Solution with comments-
class Solution {
    public int calculate(String s) {
        Stack<Integer> st=new Stack<>();
        if(s==null || s.length()==0) return 0;
        int num=0;
        char oper='+';
        int ans=0;
        
        for(int i=0;i<s.length();i++){
            char ch =s.charAt(i);
            if(Character.isDigit(ch)){
                num=num*10+(ch-'0');
            }
            if((ch!=' ' && !Character.isDigit(ch)) || i==s.length()-1){//adding to stack only when we encouunter an operator
                if(oper=='+'){
                    st.push(num);
                }
                else if(oper=='-'){
                    st.push(num*-1);
                }
                else if(oper=='*'){
                    st.push(st.pop()*num);
                }
                else if(oper=='/'){
                    st.push(st.pop()/num);
                }
                oper=ch;
                num=0;
            }
        }
            
        while(!st.isEmpty()){//add all the elements in the end
            ans+=st.pop();
        }
        
        return ans;
    }
}