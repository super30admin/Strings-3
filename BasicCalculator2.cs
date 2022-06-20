using System;
using System.Collections.Generic;

namespace Algorithms
{
    public class BasicCalculator2
    {
        /// Time Complexity : O(n)
        // Space Complexity :O(n)
        // Did this code successfully run on Leetcode :Yes
        // Any problem you faced while coding this :  Referred Online
        public int Calculate(string s)
        {
            if (s == null || s.Length == 0) return 0;
            Stack<int> st = new Stack<int>();
            char[] charArray = s.ToCharArray();
            int currentNumber = 0;
            char operation = '+';
            for (int i = 0; i < s.Length; i++)
            {
                char currentChar = charArray[i];
                if (Char.IsDigit(currentChar))
                {
                    currentNumber = (currentNumber * 10) + (currentChar - '0');
                }
                if (!Char.IsDigit(currentChar) && !Char.IsWhiteSpace(currentChar) ||
                  i == s.Length - 1)
                {
                    if (operation == '-')
                    {
                        st.Push(currentNumber * -1);
                    }
                    else if (operation == '+')
                    {
                        st.Push(currentNumber);
                    }
                    else if (operation == '*')
                    {
                        st.Push(st.Pop() * currentNumber);
                    }
                    else if (operation == '/')
                    {
                        st.Push(st.Pop() / currentNumber);
                    }
                    operation = currentChar;
                    currentNumber = 0;
                }

            }
            int result = 0;
            while (st.Count != 0)
            {
                result += st.Pop();
            }
            return result;
        }

        /// Time Complexity : O(n)
        // Space Complexity :O(1)
        // Did this code successfully run on Leetcode :Yes
        // Any problem you faced while coding this :  Referred Online
        public int Calculate_WithoutStack(string s)
        {
            if (s == null || s.Length == 0) return 0;
            char[] charArray = s.ToCharArray();
            int currentNumber = 0;
            int calc = 0;
            int tail = 0;
            char operation = '+';
            for (int i = 0; i < s.Length; i++)
            {
                char currentChar = charArray[i];
                if (Char.IsDigit(currentChar))
                {
                    currentNumber = (currentNumber * 10) + (currentChar - '0');
                }
                if (!Char.IsDigit(currentChar) && !Char.IsWhiteSpace(currentChar) ||
                  i == s.Length - 1)
                {
                    if (operation == '-')
                    {
                        calc -= currentNumber;
                        tail = -currentNumber;
                    }
                    else if (operation == '+')
                    {
                        calc += currentNumber;
                        tail = +currentNumber;
                    }
                    else if (operation == '*')
                    {
                        calc = calc - tail + tail * currentNumber;
                        tail = tail * currentNumber;
                    }
                    else if (operation == '/')
                    {
                        calc = calc - tail + tail / currentNumber;
                        tail = tail / currentNumber;
                    }
                    operation = currentChar;
                    currentNumber = 0;
                }

            }
            return calc;
        }
    }
}
