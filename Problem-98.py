'''
leet code- 227 - Basic Calculator -II - https://leetcode.com/problems/basic-calculator-ii/
time complexity - O(N)
space complexity -0(N)
Approach - Stacks for addition and subtraction we sppend the elements into stack, for "*" and "/" we pop the lement form stack and multiply with next element.
'''





class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        stack=[]
        num=0
        sign='+'
        
        for i in range(len(s)):
            c=s[i]
            if c.isdigit():
                
                num=num*10 +int(c)
            if  not c.isdigit() and  c!= " " or i==len(s)-1:
                if sign=='+':
                    stack.append(num)
                elif sign=='-':
                    stack.append(-num)
                elif sign=='*':
                    temp=stack.pop()
                    stack.append(temp*num)
                elif sign=="/":
                    temp=stack.pop()
                    if temp//num<0 and temp%num!=0:
                        stack.append(int(temp /num+1))
                    else:
                        stack.append(int(temp /num))
                sign=c
                num=0
           
        print(stack)
        res=0
        while stack:
            res=res+stack.pop()
        return res
                               
                   
            
            
        
                