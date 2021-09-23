"""
Time Complexity : O(n) is the length of the string
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def calculate(self, s: str) -> int:
        if len(s) == 0:
            return 0
        num = 0
        lastSign = '+'
        calc = tail = 0
        # We loop through the string and store the last sign that we saw and a tail
        # value that we store along with the sign. According to the operation we 
        # calculate the new value and tail and finally give out the answer
        for i in range(len(s)):
            char = s[i]
            if char.isdigit():
                num = num*10 + int(char)
            if (char.isdigit() == False and char != " ") or (i == len(s) - 1):
                if lastSign == '+':
                    calc += num
                    tail = num
                elif lastSign == '-':
                    calc -= num
                    tail = -num
                elif lastSign == '*':
                    calc = calc - tail + tail * num
                    tail = tail * num
                else:
                    calc = calc - tail + tail // num
                    tail = tail // num
                lastSign = char
                num = 0
        return calc
                