'''
TIme Complexity - O(n)
Space Complexity - O(n)

Works on Leetcode
'''


class Solution:
    def __init__(self):
        self.i = 0
    def calculate(self, s: str) -> int:
        s=s.strip()
        res = 0
        curr = 0
        lastSign = "+"
        #stack = deque()
        # for i in range(len(s)):
        #     if s[i].isdigit():
        #         curr = curr*10+ord(s[i])-ord('0') #number fromation for subsequent numerals
        #     if (s[i]=="+" or s[i]=="-" or (i == len(s)-1 and s[i]!=")")): #for non numerals and last character in the string
        #         if lastSign == "+":
        #             stack.append(curr) # push the current number onto stak if lastSign is +
        #         else:
        #             stack.append(-curr) # push the current number as -ve onto stack if lastSign is -
        #         curr = 0 #set current number to 0
        #         lastSign = s[i] #set lastSign to current character
        #     elif s[i] == "(":
        #         if lastSign == "+":
        #             stack.append(1) #push +1 onto stack as + sign before "("
        #         else:
        #             stack.append(-1) #push -1 onto stack as + sign before "("
        #         stack.append(1e9) #push 1e9 as ( onto stack
        #         curr = 0 #set curr to 0
        #         lastSign="+" #set lastSign as +
        #     elif s[i] == ")":
        #         if lastSign == "+":
        #             stack.append(curr) #push the last number within brackets on to stack
        #         else:
        #             stack.append(-curr) #push the last number within brackets onto stack
        #         tempRes = 0
        #         while stack[-1] != 1e9:
        #             tempRes += stack.pop() #calculate the result of calculation within ()
        #         stack.pop() #pop the ( sign
        #         stack.append(stack.pop()*tempRes) #push the result with the sign before() onto stack
        #         curr = 0
        #         lastSign = "+"
        #     else:
        #         i+=1 #else ignore the chracter
        # while len(stack)>0: 
        #     res += stack.pop() #calculate the final result by popping the numbers with stack and add (sign will be effective)
        # return res
        #using DFS
        while self.i<len(s):
            if s[self.i].isdigit():
                curr = curr*10+ord(s[self.i]) - ord('0')
                self.i+=1
                if self.i == len(s):
                    if lastSign == "+":
                        res+=curr
                    else:
                        res-=curr 
            elif s[self.i] == "(":
                self.i+=1
                inter = self.calculate(s) #calculate the inside the brackets following the same process
                if lastSign == "+":
                    res+=inter
                else:
                    res-=inter
                curr = 0
                lastSign = "+"
            elif s[self.i] == ")":
                self.i+=1
                if lastSign == "+":
                    res+=curr
                else:
                    res-=curr
                return res
            elif s[self.i]=="+" or s[self.i]=="-":
                if lastSign == "+":
                    res+=curr
                else:
                    res-=curr
                curr = 0
                lastSign = s[self.i]
                self.i+=1
            else:
                self.i+=1
        return res
        

            
