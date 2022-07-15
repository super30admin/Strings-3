# Time Complexity : O(n)
# Space Complexity : O(1);
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
class Solution:
    def calculate(self, s: str) -> int:
        calc, tail = 0, 0
        lastsign = '+'
        currNum = 0
        for i in range(len(s)):
            if s[i].isdigit():
                currNum = currNum*10 + int(s[i])
            if (not s[i].isdigit() and s[i] != ' ') or i == len(s)-1:
                if lastsign == '+':
                    calc += currNum
                    tail = currNum
                elif lastsign == '-':
                    calc -= currNum
                    tail = -currNum
                elif lastsign == '*':
                    calc = (calc - tail) + (tail*currNum)
                    tail = tail * currNum
                elif lastsign == '/':
                    calc = (calc - tail) + int((tail/currNum))
                    tail = int(tail / currNum)
                lastsign = s[i]
                currNum = 0
        return calc


print(Solution().calculate("14-3/2"))
