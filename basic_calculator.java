// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int calculate(String s) {
        if(s.length()==0 || s==null)
        {
            return 0;
        }
        s.trim();
        int num=0;
        char lastsign='+';
        int cal=0;
        Stack<Integer> sk = new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char c =s.charAt(i);
            if(Character.isDigit(c))
            {
                num = num * 10 + c - '0';
            }
            if((!Character.isDigit(c) && c!=' ') || i == s.length()-1)
            {
                if(lastsign=='+')
                {
                    sk.push(num);
                    num=0;
                    lastsign=c;
                }
                else if(lastsign=='-')
                {
                    sk.push((-1)* num);
                    num=0;
                    lastsign=c;
                }
                else if(lastsign=='*')
                {
                    sk.push(sk.pop()*num);
                    num=0;
                    lastsign=c;
                }
                else
                {
                    sk.push(sk.pop()/num);
                    num=0;
                    lastsign=c;
                }
            }
        }
        while(!sk.isEmpty())
        {
            cal=cal+sk.pop();
        }
        return cal;
    }
}
