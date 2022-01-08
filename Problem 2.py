# Time: O(n)
# Space: O(n)
class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        #print(math.ceil(-3.0/2))
        stack = []
        num = 0
        last_sign = '+'
        for i in range(len(s)):
            val = ord(s[i])
            if val >=48 and val <=57:
                num = (num*10+(val-48))
            #print(num)
            if s[i] == '+' or s[i] == '-' or s[i] == '*' or s[i] == '/' or i == len(s)-1:
                if last_sign == '+':
                    stack.append(num)
                elif last_sign == '-':
                    stack.append(-1*num)
                elif last_sign == '*':
                    stack.append(stack.pop()*num)
                elif last_sign == '/':
                    prev = stack.pop()
                    if prev < 0:
                        prev *= -1
                        stack.append(-1*(prev/num))
                    else:
                        stack.append((prev/num))
                num = 0
                last_sign = s[i]
        #print(stack)
        return sum(stack)
            
                
        
        
