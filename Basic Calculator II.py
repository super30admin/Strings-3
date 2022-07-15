""""// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""
class Solution:
    def calculate(self, s: str) -> int:
        currNum = 0
        lastSign = '+'
        calc = 0
        tail = 0
        for i in range(len(s)):
            c = s[i]
            if c.isdigit():
                currNum = currNum * 10 + int(c)
            if (c.isdigit() == False and c != ' ') or i == len(s) - 1:
                if lastSign == '+':
                    calc += currNum
                    tail = currNum
                elif lastSign == '-':
                    calc -= currNum
                    tail = -currNum
                elif lastSign == '*':
                    calc = (calc - tail) + (tail * currNum)
                    tail = tail * currNum
                elif lastSign == '/':
                    calc = (calc - tail) + int((tail / currNum))
                    tail = int(tail / currNum)

                currNum = 0
                lastSign = c
        return calc


#Stack Approach
""""// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""
# class Solution:
#     def calculate(self, s: str) -> int:
#         stack=[]
#         currNum=0
#         lastSign='+'

#         for i in range(len(s)):
#             c=s[i]
#             if c.isdigit():
#                 currNum=(currNum*10)+int(c)
#                 # print(currNum)

#             if (c.isdigit()==False and c!=' ') or i==len(s)-1:
#                 if lastSign=='+':
#                     stack.append(currNum)
#                 if lastSign=='-':
#                     stack.append(-currNum)
#                 if lastSign=='*':
#                     stack.append(stack.pop()*currNum)
#                 if lastSign=='/':
#                     stack.append(int(stack.pop()/currNum))
#                 currNum=0
#                 lastSign=c

#         if len(stack)!=0:
#             return sum(stack)

