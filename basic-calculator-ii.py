# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution:
    def calculate(self, s: str) -> int:
        num=0
        sign='+'
        stack=[]
        for i in range(len(s)):
            if s[i].isdigit():
                num=num*10+(ord(s[i])-ord('0'))
            if (not s[i].isdigit() and s[i]!=' ') or i==len(s)-1:
                if sign=='+': stack.append(num)
                elif sign=='-': stack.append(-1*num)
                elif sign=='*': stack.append(stack.pop()*num)
                elif sign=='/': stack.append(int(stack.pop()/num))
                num=0
                sign=s[i]
        return sum(stack)