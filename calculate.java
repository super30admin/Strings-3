//Time Complexity: O(n), where n is the length of string s. We iterate over the string s max twice.

//Space Complexity: O(n), where n is the length of string s.



class Solution {
    public int calculate(String s) {
        if(s==null || s.length()==0)
            return 0;
        Stack<Integer> s1=new Stack<>();
        char lastsign='+';
        int num=0;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(Character.isDigit(c))
            {
                num=num*10+c-'0';    
            }
            if((!Character.isDigit(c) && !Character.isSpace(c))|| i==(s.length()-1))
            {
                if(lastsign=='+')
                    s1.push(num);
                else if(lastsign=='-')
                    s1.push(-num);
                else if(lastsign=='*')
                    s1.push(s1.pop()*num);
                else
                    s1.push(s1.pop()/num);
                num=0;
                lastsign=c;
            }
        }
        
        int result=0;
        while(!s1.isEmpty())
        {
            result+=s1.pop();
        }
        
        return result;
    }
}
