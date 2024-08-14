#// Time Complexity : O(n) 
# // Space Complexity : O(1) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : No saw the class video and then did the problem.

class Solution:
    def calculate(self, s: str) -> int:
        calc = 0
        tail = 0
        num = 0
        lastsign = '+'
        s = s.strip()
        for i in range(len(s)):
            c = s[i]
            if c.isdigit():
                num = num * 10 + int(c)

            if not c.isdigit() and c != ' ' or i == len(s) - 1:
                if lastsign == '+':
                    calc = calc + num
                    tail = num
                elif lastsign == '-':
                    calc = calc - num
                    tail = -num
                elif lastsign == "*":
                    calc = calc - tail + tail * num
                    tail = tail * num
                elif lastsign == '/':
                    calc = calc - tail + int(tail / num)
                    tail = int(tail / num)
                num = 0
                lastsign = c
            
        return calc

# Approach:
# The approach is to iterate through the string, and whenever we encounter a digit, we add it to
# the current number. Whenever we encounter an operator, we perform the operation with the current
# number and the previous number, and then update the current number. We keep track of the last sign
# encountered to know what operation to perform.


