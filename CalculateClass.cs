// TC => O(n)
// SC => O(1)

public class Solution
{
    public int Calculate(string s)
    {
        if (string.IsNullOrEmpty(s))
        {
            return 0;
        }

        int calc = 0, num = 0, tail = 0;
        char lastSign = '+';

        for (int i = 0; i < s.Length; i++)
        {
            if (char.IsDigit(s[i]))
            {
                num = 10 * num + s[i] - '0';
            }
            if ((!char.IsDigit(s[i]) && s[i] != ' ') || (i == s.Length - 1))
            {
                if (lastSign == '+')
                {
                    calc = calc + num;
                    tail = +num;

                }
                if (lastSign == '-')
                {
                    calc = calc - num;
                    tail = -num;
                }
                if (lastSign == '*')
                {
                    calc = calc - tail + (tail * num);
                    tail = tail * num;
                }
                if (lastSign == '/')
                {
                    calc = calc - tail + (tail / num);
                    tail = tail / num;
                }
                num = 0;
                lastSign = s[i];
            }
        }
        return calc;
    }
}