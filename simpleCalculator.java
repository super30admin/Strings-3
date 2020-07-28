// Time Complexity : O(n) // n - length of s
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
class Solution {
    public int calculate(String s) {
        Stack<Integer> st=new Stack<>(); 
        int num=0;
        char lastSign='+';
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            char c=s.charAt(i);
            if(Character.isDigit(c))
            {
                num=num*10+c-'0';
            }
            if((!Character.isDigit(c) && c!=' ') || i+1==n)
            {
            if(lastSign=='+') st.push(num);
            else if(lastSign=='-') st.push(-num);
            else if(lastSign=='*') st.push(st.pop()*num);
            else st.push(st.pop()/num); 
            num=0; lastSign=c;
               
            }
        
        }
        num=0;
        while(!st.isEmpty())
        {
            num+=st.pop();
        }
        return num;
    }
}