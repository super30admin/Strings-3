// Time Complexity : O(n) - where n is the number of characters in the given string.
// Space Complexity :O(n/2)-> O(n) - worst case asymptotic complexity
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
// Your code here along with comments explaining your approach: Basic calculator (doesnot work for invalid cases/invalid expressions). The approach used is for maintaining the last digit which is the sign of the next upcoming digits. When we encounter the next character, we push the element with it's sign into the stack.
// If it is a * or /, we pop the current tip of the stack, perfom the respective operation with the top and push it back into the stack.


class Solution {
    public int calculate(String s) {
        if(s==null || s.length()==0) return 0;
        Stack<Integer> st=new Stack<>();
        char lastSign='+';int num=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                num=num*10+c-'0';
            }
            if((!Character.isDigit(c) && c!=' ') || i==n-1){
                if(lastSign=='+') st.push(num);
                if(lastSign=='-') st.push(-num);
                if(lastSign=='*'){
                    int ch=st.pop();
                    st.push(ch*num);
                }
                if(lastSign=='/'){
                    int ch=st.pop();
                    st.push(ch/num);
                } 
                lastSign=c;num=0;
            }
            
        }
        int ans=0;
        while(!st.isEmpty()){
            ans+=st.pop();
        }
        return ans;
    }
}