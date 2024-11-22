class Solution {
    public int calculate(String s) {
        char lsign='+';
        int currNum=0;
        Stack<Integer> st = new Stack<>();
        int i=0;
        while(i<s.length()){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                currNum=currNum*10+(c-'0');
            }
            if((!Character.isDigit(c) && c!=' ') || i==s.length()-1){
                if(lsign=='+') st.push(currNum);
                else if(lsign=='-') st.push(-currNum);
                else if(lsign=='*') st.push(st.pop()*currNum);
                else if(lsign=='/') st.push(st.pop()/currNum);
                lsign=c;
                currNum=0;
            }
            i++;
        }
        int res=0;
        while(!st.isEmpty()){
            res+=st.pop();
        }
        return res;
    }
}
