//using recursion
class Solution {    
    public int calculate(String s) {
        //return calculateUtil(s.trim(), 0, 0, 0, '#');
        return calculateUtilUsingStack(s);
    }
    private int calculateUtil(String s, int index, int calVal, int preVal, char sign){
        //edge case
        if(index == s.length())
            return calVal;
        int curVal =0;
        //current char is space just ignore it
        if(s.charAt(index) == ' ') 
            return calculateUtil(s, index+1, calVal , preVal, sign);
        //current char is number/digit
        if(Character.isDigit(s.charAt(index))){
            //get the current number in the calculated value
            while(index < s.length() && Character.isDigit(s.charAt(index))){
                curVal = 10* curVal + Character.getNumericValue(s.charAt(index));
                index++;
            }
            index-=1;
            //in case of multiplication and  division operation whatever mess I had created in the previous calculation, will 
            //remove that, do the current calculation and substract previous mess to nullify that. 
            if (sign == '*'  )
                return calculateUtil(s, index+1, calVal- preVal + preVal* curVal , preVal* curVal,'#');
            if (sign == '/'  )
                return calculateUtil(s, index+1, calVal- preVal + preVal/ curVal , preVal/curVal,'#');
            if(sign =='+')
                return calculateUtil(s, index+1, calVal+ curVal , curVal, '#');
            if(sign == '-')
                return calculateUtil(s, index+1, calVal- curVal , -curVal, '#');   
            return calculateUtil(s, index+1, curVal , curVal, '#');
        }
        return calculateUtil(s, index+1, calVal , preVal, s.charAt(index));
    }
    private int calculateUtilUsingStack(String s){
        Stack<Integer> st= new Stack<>();
        int num=0;
        char sign ='+';
        if(s.length()==1)
            return Integer.parseInt(String.valueOf(s.charAt(0)));
         int i=0;
         while(i <= s.length()) {
            char c = i == s.length() ? 0 : s.charAt(i);
            if(Character.isDigit(c)){
                //calculating the number i.e 42
                while(i < s.length() && Character.isDigit(s.charAt(i))){
                    num = 10* num + Character.getNumericValue(s.charAt(i));
                    i++;
                }
                i-=1;
            }
            if(!Character.isDigit(c) && c!= ' ' ){
                if(sign == '+')
                    st.push(num);
                else if(sign == '-')
                    st.push(-num);
                else if(sign == '*')
                    st.push(st.pop() * num);
                else if(sign == '/')
                    st.push(st.pop() / num);
                sign = c;
                num=0;
            }
           i++;
        }
        int ans= 0;
        for(int j: st)
            ans+=j;
        
        return ans;
    } 
}
