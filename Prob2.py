class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        # Time complexity: O(n)
        #Space : O(1)
        tail = 0
        lastSign = '+'
        calc = 0
        num = 0
        s = s.strip()
        for idx,el in enumerate(s):
            if el.isdigit():
                num = num *10 + int(el)
            if el != ' ' and (not el.isdigit() or idx==len(s)-1):
                if lastSign == '+':
                    calc = calc + num
                    tail = num
                elif lastSign == '-':
                    calc = calc - num
                    tail = -num
                elif lastSign == '*':
                    calc = calc-tail+tail*num
                    tail = tail*num
                else:
                    if (tail<0 and num>0) or (tail>0 and num<0):
                        calc = calc-tail- abs(tail)/abs(num)
                        tail = -1* abs(tail)/abs(num)
                    else:
                        calc = calc-tail+tail//num
                        tail = tail//num
                    
                num =0
                lastSign = el
            
        return calc
#         # Time complexity: O(n)
#         #Space : O(n)
#         numStack = []
#         lastSign = '+'
#         num = 0
#         s = s.strip()
#         for idx,el in enumerate(s):
#             if el.isdigit():
#                 num = num *10 + int(el)
#             if el != ' ' and (not el.isdigit() or idx==len(s)-1):
#                 if lastSign == '+':
#                     numStack.append(num)
#                 elif lastSign == '-':
#                     numStack.append(-1*num)
#                 elif lastSign == '*':
#                     temp = numStack.pop()
#                     num = temp * num
#                     numStack.append(num)
#                 else:
#                     temp = numStack.pop()
#                     num = abs(temp) / abs(num)
#                     if temp<0 and num<0:
#                         numStack.append(num)
#                     elif temp<0 or num<0:
#                         numStack.append(-num)
#                     else:
#                         numStack.append(num)
#                 num =0
#                 lastSign = el
            
#         return sum(numStack)
