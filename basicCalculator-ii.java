//time complexity: O(N)
//space complexity: O(N)

class Solution {
    public int calculate(String s) {
        char lastSign='+'; // 23+6*2
        int num=0;
        int i=0;
        Stack<Integer> st=new Stack<>();
        while(i < s.length())
        {
            char c=s.charAt(i);
            if(Character.isDigit(c))
            {
                num = num*10 + c-'0';
            }
            if((!Character.isDigit(c) && c !=' ')|| i==s.length()-1)
            {
                if(lastSign=='+') st.push(num);
                if(lastSign=='-') st.push(-num);
                if(lastSign=='*') st.push(st.pop()*num);
                if(lastSign=='/') st.push(st.pop()/num);
                lastSign=c; 
                num=0;
            }
            i++;
            
        }
        int sum=0;
        while(!st.isEmpty())
        {
            sum+=st.pop();
        }
        return sum;    
        
    }
}