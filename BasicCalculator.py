
#time complexity = O(N)
#Space Complexity = O(1)

class Solution:
    def calculate(self, s: str) -> int:
        if s == None or len(s) == 0:
            return 0
        
        num = 0
        cal = 0
        tail = 0
        lastsin = '+'
        for i in range(len(s)):
            c = s[i]
            if(c.isdigit()):
                num = num * 10 + (int)(c) 
            if((not c.isdigit() and c != " ") or (i == len(s)-1)):
                if(lastsin == '+'):
                    cal = cal + num
                    tail = + num
                if(lastsin == '-'):
                    cal = cal - num
                    tail = - num
                if(lastsin == '*'):
                    cal = cal - tail + tail * num
                    tail = tail * num
                if(lastsin == '/'):
                    cal = cal - tail + int(tail / num)
                    tail = int(tail /  num)
                lastsin = c
                num = 0
        return cal
    
    
    
# class Solution:
#     def calculate(self, s: str) -> int:
#         if s == None or len(s) == 0:
#             return 0
        
#         num = 0
#         cal = 0
#         #tail = 0
#         lastsin = '+'
#         stack = []
#         for i in range(len(s)):
#             c = s[i]
#             if(c.isdigit()):
#                 num = num * 10 + (int)(c) 
#             if((not c.isdigit() and c != " ") or (i == len(s)-1)):
#                 if(lastsin == '+'):
#                     stack.append(int(num))
#                 if(lastsin == '-'):
#                     stack.append(- num)
#                 if(lastsin == '*'):
#                     stack.append(stack.pop() * num)
#                 if(lastsin == '/'):
#                     stack.append(int(stack.pop() / num))
#                 lastsin = c
#                 num = 0
#         while (len(stack) > 0):
#             cal = cal + stack.pop()
#         return cal