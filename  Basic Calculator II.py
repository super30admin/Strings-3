# time complexity is o(n), where n is the size of the input
# space complexity is o(1).
class Solution:
    def calculate(self, s: str) -> int:
        currnum = 0
        lastsign = '+'
        tail = 0
        calc = 0
        for i in range(len(s)):
            if(s[i].isdigit()):
                currnum = currnum*10 + ord(s[i]) - ord('0')
                # tail = currnum
            if((s[i] != " " and not s[i].isdigit()) or i == len(s)-1):
                if(lastsign == '+'):
                    calc += currnum
                    tail = currnum
                if(lastsign == '-'):
                    calc -= currnum
                    # lastsign = i
                    tail = -currnum
                if(lastsign == "*"):
                    calc = calc - tail + tail*currnum
                    tail = tail*currnum
                if(lastsign == "/"):
                    if(tail < 0 and tail%currnum != 0):
                        calc = calc - tail + tail//currnum + 1
                        tail = tail//currnum + 1
                    else:
                        calc = calc - tail + tail//currnum
                        tail = tail//currnum
                lastsign = s[i]
                currnum = 0
        return calc
                
                
                
                
                
                
                
                
                
                
                
                
                
# time complexity is o(n), where n is the time of the input.
# space complexity is o(n),where n is the time of the input.(propotional to n)
#         stack = list()
#         currnum = 0
#         lastsign = '+'
#         res = 0
#         for i in range(len(s)):
#             # print(s[i])
#             if(s[i].isdigit()):
#                 currnum = currnum*10 + ord(s[i]) - ord('0') #( int(s[i]) )
            
#             if((not s[i].isdigit() and s[i] != " ") or i == len(s)-1):
#                 if(lastsign == "+"):
#                     stack.append(currnum)
#                 if(lastsign == "-"):
#                     stack.append(-currnum)
#                 if(lastsign == "*"):
#                     p = stack.pop()
#                     stack.append(p*currnum)
#                 if(lastsign == "/"):
#                     p = stack.pop()
#                     if(p < 0 and p%currnum != 0):
#                         stack.append(p//currnum + 1)
#                     else:    
#                         stack.append(p//currnum)
#                 currnum = 0
#                 lastsign = s[i]
#         while(len(stack) > 0):
#             res += stack.pop()
#         return res
            
                    
                    
                
        