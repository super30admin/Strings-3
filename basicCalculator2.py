#Accepted on leetcode
#Time complexity - O(n) as we traverse entire string
#Space omplexity - O(n) since we are using physical stack

class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        curr = 0
        sign = '+'
        i = 0
        stack = []
        while i < len(s):
            c = s[i]
            #Case1: check if it is a digit
            if c.isdigit():
                curr = curr * 10 + int(c)
            if not c.isdigit() and c!= ' ' or i == len(s)-1:
                if sign == '+':
                    stack.append(+curr)
                elif sign == '-':
                    stack.append(-curr)
                elif sign == '*':
                    stack.append(+(stack.pop() * curr))
                elif sign == '/':
                    stack.append(+(stack.pop() / curr))
                curr = 0
                sign = c
            i += 1
        curr = 0
        while len(stack) > 0:
            curr += stack.pop()
        return curr