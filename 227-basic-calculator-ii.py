
"""
227. Basic Calculator II
Medium
"""
from collections import deque
import math
from leetcode_runner import LeetCode, TestCase, Args
from typing import *

PROBLEM = """
Given a string s which represents an expression, evaluate this expression and return its value. 
The integer division should truncate toward zero.
You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].
Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 
Example 1:
Input: s = "3+2*2"
Output: 7
Example 2:
Input: s = " 3/2 "
Output: 1
Example 3:
Input: s = " 3+5 / 2 "
Output: 5

 
Constraints:

1 <= s.length <= 3 * 105
s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
s represents a valid expression.
All the integers in the expression are non-negative integers in the range [0, 231 - 1].
The answer is guaranteed to fit in a 32-bit integer.


"""

class Solution:
    """
    Accepted
    Time Complexity: O(n) where n is the length of the string
    Space Complexity: O(n) stack space 
    
    Approach:
    - We can use a stack to solve this problem. We can iterate through the string and keep track of the current number and the last sign
    - We can use a stack to keep track of the numbers and the signs
    - In the case of + and -, just put the number into the stack (maintain the sign)
    - In the case of * and /, pop the last number from the stack and perform the operation and put the result back into the stack
    - Finally, we can sum up the stack and return the result
    
    #NOTE -> This had an absurd amount of edge cases and it was a bit tricky to get the logic right
        1. The part where 3/2 = 1 and -3/2 = -1 was a bit tricky to get right because by defautl python does floor division and the negative floor 
        was giving me wrong ansers
        
        2. the part where we need to handle the case of 3+5/2 was a bit tricky to get right because we need to handle the case of the last number
        3. When we hit the end of the string, we need to handle the last number and the last sign case. 
    """
    def calculate(self, s: str) -> int:
        if len(s) == 1: return int(s)
        curr = 0
        lastSign = '+'
        stk = deque()
        i=0
        signMap = {
            "+": 1,
            "-": -1
        }
        spl = False # SPECIAL -> * or / case
        temp = -1
        
        def divideCase(temp, curr):
            if temp / curr < 0:
                return math.ceil(temp / curr)
            else:
                return temp // curr

        while i < len(s):
            _ = s[i]
            if _ == " ":
                pass
            elif _.isdigit():
                curr = curr * 10 + int(_) # collect the number
            elif _ in ("+","-", "*","/"):
                if spl:
                    # assuming we have popped the previous number from the stack into temp
                    if lastSign == "*":
                        stk.append(temp * curr)
                    if lastSign == "/":
                            stk.append(divideCase(temp, curr)) # handle the divide case
                else:
                    stk.append(curr * signMap[lastSign])
                if _ in ("+","-"):
                    lastSign = _
                    spl = False
                elif _ in _ in ("*","/"):
                    temp = stk.pop() # pop the last number from the stack and save it
                    spl = True
                    lastSign = _
                curr = 0 #always reset the current number to 0
            
            if i == len(s)-1: # end of string check
                    if spl:
                        if lastSign == "*":
                            stk.append(temp * curr)
                        if lastSign == "/":
                            stk.append(divideCase(temp, curr))
                    else:
                        stk.append(curr * signMap[lastSign])
            i += 1
        res = 0
        while len(stk) > 0:
            res += stk.pop()
        return res

LeetCode(PROBLEM, Solution).check()
