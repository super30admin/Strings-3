/*
  Time complexity: O(n)
  Space complexity: O(1)
*/

public class Solution {
    public int Calculate(string s) {
        if(s==null) return 0;

        s=s.Trim();
        if(s.Length==0) return 0;
        int current = 0;
        int calc = 0;
        int tail = 0;
        char sign = '+';

        for(int i=0;i<s.Length;i++)
        {
            if(Char.IsDigit(s[i]))
            {
                current = current*10 + s[i]-'0';
            }
            if((!Char.IsDigit(s[i]) && s[i]!=' ') || (i==s.Length-1))
            {
                if(sign=='+')
                {
                    calc = calc+current;
                    tail = current;
                }
                else
                if(sign=='-')
                {
                    calc = calc - current;
                    tail = -current;
                }
                else
                if(sign=='*')
                {
                    calc = calc - tail + tail*current;
                    tail = tail*current;
                }
                else
                {
                    calc = calc - tail + tail/current;
                    tail = tail/current;
                }
                current = 0;
                sign = s[i];
            }
        }
        return calc;
    }
}
