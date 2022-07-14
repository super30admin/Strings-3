// Time Complexity: O(n)
// Space Complexity: O(proportional to the length os string)
class Solution {
    public int calculate(String s) {
        int currNum=0;
        char lastSign='+';
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                currNum=currNum*10 + c - '0';
                
            }
            if(!Character.isDigit(c) && c != ' ' || i==s.length()-1){
                if(lastSign=='+') st.push(currNum);
                    if(lastSign=='-') st.push(-currNum);
                        if(lastSign=='*') st.push(st.pop() * currNum);
                            if(lastSign=='/') st.push(st.pop() / currNum);
                currNum=0;
                lastSign=c;
            }
            
        }
        int res=0;
            while(!st.isEmpty()){
                res= res + st.pop();
            }
        return res;
    }
}
