class Solution:
    def calculate(self, s: str) -> int:
        
        ## T.C = O(n)
        ## S.C = O(n)
        
        ## Approach 2 using stack
        stack = []
        num = 0
        i = 0 
        n = len(s)
        last_sign = "+"

        while i < n:
            if s[i].isdigit():
                num = num*10 + int(s[i])
            
            if (not s[i].isdigit() and s[i]!= " ") or (i == len(s) - 1):
                if last_sign == "+":
                    stack.append(num)
                elif last_sign == "-":
                    stack.append(-num)
                elif last_sign == "*":
                    tmp = stack.pop()
                    tmp = tmp * num
                    stack.append(tmp)
                elif last_sign == "/":
                    tmp = stack.pop()
                    tmp = math.trunc(tmp / num)
                    stack.append(tmp)
            
                last_sign = s[i]
                num = 0

            i += 1
            
        return sum(stack)
                

        ## Approach 1 using string
        ## T.C = O(n)
        ## S.C = O(1)
        
        last_sign = '+'
        calc = 0
        num = 0
        tail = 0

        for i in range(len(s)):
            if s[i].isdigit():
                num = num*10 + int(s[i])
            
            if (not s[i].isdigit() and s[i]!= " ") or (i == len(s) - 1):
                if last_sign == '+':
                    calc += num
                    tail = num
                elif last_sign == '-':
                    calc -= num
                    tail = -num
                elif last_sign == '*':
                    calc = (calc - tail) + (tail * num)
                    tail = tail * num
                elif last_sign == '/':
                    calc = (calc - tail) + math.trunc((tail / num))
                    tail = math.trunc((tail / num))
                
                last_sign = s[i]
                num = 0
                
        return calc