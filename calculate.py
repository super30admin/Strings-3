# Time Complexity : O(n)
#Space Complexity:O(n)
#Ran successfully on Leetcode:Yes
#Algo:
#1. iterate through the string
#2.If char is digit ,store in a temp variable, if not a digit and is a space or index has reached end of the string, check for the lastsign stored, and manipulate value and replace the top value in the stack 
class Solution:
    def calculate(self, s: str) -> int:
        stack=[]
        lastsign='+'
        num=0
        for i in range(len(s)):
            if s[i].isdigit():
                num=num*10+int(s[i])
            if not s[i].isdigit() and s[i]!=" " or i==len(s)-1:
                if lastsign=="+":
                    stack.append(num)
                if lastsign == "-":
                    stack.append(-num)

                if lastsign == "*":
                    stack.append(stack.pop() * num)
                    
                if lastsign == "/":
                    stack.append(int(stack.pop() / num))
                
                lastsign=s[i]
                num=0
        return sum(stack)
            

                    

                

                    

                
    

  

   

#         stack = []

#         lastsign = "+"

#         num = 0

#         for i in range(len(s)):

#             if s[i].isdigit():

#                 num = num * 10 + int(s[i])

#             if (not s[i].isdigit()) and s[i] != " " or i == len(s) - 1:

#                 if lastsign == "+":

#                     stack.append(num)

#                 if lastsign == "-":

#                     stack.append(-num)

#                 if lastsign == "*":

#                     stack.append(stack.pop() * num)

#                 if lastsign == "/":

#                     stack.append(int(stack.pop() / num))

#                 lastsign = s[i]

#                 num = 0

#         return sum(stack)

