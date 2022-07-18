#code using the stack
#TC: O(n)
#SC: O(n)
class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        lastSign='+'
        currNum=0
        stack=[]
        result=0
        for i in range(len(s)):
            if s[i].isdigit():
                currNum=(currNum*10)+int(s[i])
            if (not s[i].isdigit() and s[i]!=' ') or i==len(s)-1:
                if lastSign=='+':
                    stack.append(currNum)
                elif lastSign=='-':
                    stack.append(currNum*(-1))
                elif lastSign=='*':
                    stack.append(stack.pop()*currNum)
                elif lastSign=='/':
                    k=stack.pop()
                    if k>=0:
                        stack.append(int(k/currNum))
                    else:
                        stack.append(int(abs(k)/currNum)*-1)
                
                lastSign=s[i]
                currNum=0
          
       
        while stack:
            result+=stack.pop()
        return result
#code using the tail element 
'''
# Time Complexity : O(n)
# Space Complexity : O(1);
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
class Solution:
    def calculate(self, s):
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
                    if tail>=0:
                        calc = (calc - tail) + int((tail/currNum))
                        tail = int(tail / currNum)
                    else:
                        calc = (calc - tail) + int((abs(tail)/currNum)*-1)
                        tail = int(abs(tail) / currNum)*-1
                lastsign = s[i]
                currNum = 0
        return calc
'''