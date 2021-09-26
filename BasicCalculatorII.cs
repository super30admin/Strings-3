using System;
using System.Collections.Generic;
using System.Text;

namespace Strings
{
    class BasicCalculatorII
    {
        //TC: O(n)
        //SC: O(n)
        public int Calculate(string s)
        {
            if (s == null || s.Length == 0)
            {
                return 0;
            }
            int num = 0;
            int result = 0;
            char lastSign = '+';
            Stack<int> st = new Stack<int>();
            for (int i = 0; i < s.Length; i++)
            {
                char c = s[i];
                if (char.IsDigit(c))
                {
                    num = num * 10 + c - '0';
                }
                if ((!char.IsDigit(c) && c != ' ') || (i == s.Length - 1))
                {
                    if (lastSign == '+')
                    {
                        st.Push(num);
                    }
                    else if (lastSign == '-')
                    {
                        st.Push(-num);
                    }
                    else if (lastSign == '*')
                    {
                        st.Push(st.Pop() * num);
                    }
                    else
                    {
                        st.Push(st.Pop() / num);
                    }
                    lastSign = c;
                    num = 0;
                }
                while (s.Length != 0)
                {
                    result += st.Pop();
                }               
            }
            return result;
        }
        //TC: O(n)
        //SC: O(1)
        public int CalculateAlternativeApprch(string s)
        {
            if (s == null || s.Length == 0)
            {
                return 0;
            }
            int num = 0;
            char lastSign = '+';
            int calc = 0, tail = 0;
            for (int i = 0; i < s.Length; i++)
            {
                char c = s[i];
                if (char.IsDigit(c))
                {
                    num = num * 10 + c - '0';
                }
                if ((!char.IsDigit(c) && c != ' ') || (i == s.Length - 1))
                {
                    if (lastSign == '+')
                    {
                        calc = calc + num;
                        tail = num;
                    }
                    else if (lastSign == '-')
                    {
                        calc = calc - num;
                        tail = -num;
                    }
                    else if (lastSign == '*')
                    {
                        calc = calc - tail + tail * num;
                        tail = tail * num;
                    }
                    else
                    {
                        calc = calc - tail + tail / num;
                        tail = tail / num;
                    }
                    lastSign = c;
                    num = 0;
                }

            }
            return calc;
        }
    }
}
