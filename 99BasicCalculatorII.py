"""
    // Time Complexity :O(n)
    // Space Complexity :O(n)
    // Did this code successfully run on Leetcode : YES
    // Any problem you faced while coding this : NA
    if s[i] is numeric, calculate number
    if s[i] is either + or - sign;push the number in stack
    if s[i] is either * or /; pop from the stack, perform operation and push the result
    if i is last index of s; push the element as it is
    In the end-> add all the elements of stack untill it's empty
"""
class Solution:
    def calculate(self, s: str) -> int:
        if s is None or len(s) == 0: return 0
        number = 0
        lastsign = "+"
        stack = []
        result = 0
        n = len(s) - 1
        for i in range(len(s)):
            if s[i].isdigit() == True:
                number = number*10+int(s[i])
            if (s[i].isdigit() == False and s[i] !=" ") or i ==n:
                if lastsign == "+": stack.append(number)
                elif lastsign == "-": stack.append(-number)
                elif lastsign == "*": stack.append(stack.pop()*number)
                elif lastsign == "/": stack.append(int(stack.pop()/number))
                number = 0
                lastsign = s[i]

        while stack:
            result += stack.pop()
        return result
