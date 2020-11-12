class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        stack = []
        if len(s)==0:
            return 0
        index = 0
        num = 0
        sign="+"
        while index<len(s):
            c = s[index]
            if c.isdigit():
                num = num*10 + (ord(c)-ord('0'))
            if(not(c.isdigit()) and c!=' ' or index==len(s)-1):
                if sign=='+':
                    stack.append(num)
                elif(sign=='-'):
                    stack.append(-num)
                elif(sign=='*'):
                    last = stack.pop()
                    stack.append(last*num)
                else:
                    last = stack.pop()
                    if last<0:
                        t=-last
                        k=t/num
                        stack.append(-k)
                    else:
                        stack.append(last//num)
                num = 0
                sign = c
            index+=1
            
        result = 0
        while(len(stack)!=0):
            result+=stack.pop()
        return result
            