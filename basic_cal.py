# Time complexity - O(n) (where n = length of the given string)
# Space Complexity: O(n) 
# Did this code successfully run on LeetCode?: Yes
# Problems faced while coding this:None
# Approach : Traverse from left to right and compute according to BODMAS using a stack.


class Solution:
    def calculate(self, s: str) -> int:
        if s is None or len(s) == 0:
            return 0
        
        stack = []
        num = 0
        lastsign = '+'

        for i in range(len(s)):
            if s[i].isdigit():
                num = num * 10 + ord(s[i]) - ord('0')
                
            if (not s[i].isdigit() and s[i] != ' ') or i == len(s) - 1:
                
                if lastsign == '+':
                    stack.append(num)
                
                if lastsign == "-":
                    stack.append(-num)
                
                if lastsign == "*":
                    stack.append(stack.pop() * num)
                    
                if lastsign == "/":
                    temp = stack.pop()
                    if temp < 0:
                        temp = -(-temp // num)
                    else:
                        temp = temp // num
                    stack.append(temp)
                
                num = 0
                lastsign = s[i]
                
        res = 0
        while len(stack) > 0:
            res += stack.pop()
        return res

