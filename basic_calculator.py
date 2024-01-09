"""
Time Complexity: O(n) where n is the length of the string
Space Complexity: O(1) as no auxillary data structure is used

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
Following logic is used to calculate the final ans

Example 3 + 2 * 2
operator       calc                                  tail
  +          calc + currNum                         +currNum
  -          calc - currNum                         -currNum
  *          calc - tail + (tail * currNum)         tail*currNum
  /          calc - tail + (tail / currNum)         tail/currNum

calc | tail | currNum | lastOperator
  0  |  0   |  0      |  +
     |      |  3      |  +
  3  |  3   |  0      |  +
     |      |  2      |  +
  5  |  2   |  0      |  *
     |      |  2      |  *
  7  |  4   |  0      |  *

return 7
"""


class Solution:
    def calculate(self, s: str) -> int:
        if len(s) == 0:
            return 0

        currNum = 0
        lastOperator = "+"
        calc = 0
        tail = 0
        for i in range(len(s)):
            char = s[i]
            if char.isdigit():
                currNum = currNum * 10 + ord(char) - ord("0")
            if not char.isdigit() and char != " " or i == len(s)-1:
                if lastOperator == "+":
                    calc = calc + currNum
                    tail = currNum
                elif lastOperator == "-":
                    calc = calc - currNum
                    tail = currNum * -1
                elif lastOperator == "*":
                    calc = (calc - tail) + (tail*currNum)
                    tail = tail * currNum
                elif lastOperator == "/":
                    calc = (calc - tail) + int(tail/currNum)
                    tail = int(tail / currNum)
                currNum = 0
                lastOperator = char
        return calc
