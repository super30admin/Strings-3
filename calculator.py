#Time Complexity: O(N)
#Space Complexity: O(N)
#Run on Leetcode: Yes
#Any Issues: No


class Solution:
    def calculate(self, s):
        
        def cal(s):
            pre, num, sign = 1, 0, '*'
            for c in s+'*':
                if c.isnumeric(): num = num*10 + int(c)
                elif c in {'*', '/'}: pre, sign, num = pre*num if sign == '*' else pre//num, c, 0
            return pre
        
        sign, cur, ret = 1, '', 0
        for c in s:
            if c not in {'-', '+'}: cur += c
            else: ret, sign, cur = ret + cal(cur)*sign, {'+':1, '-':-1}[c], ''
                
        return ret + cal(cur)*sign