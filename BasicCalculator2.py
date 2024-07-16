# Time Complexity:
# O(n)

# Space Complexity:  
# O(n)

# Approach: 
# Stack based approach


class Solution:
    def calculate(self, s: str) -> int:
        # Stack approach:  TC = O(n), SC = O(n)
        if not s:
            return 0
    
        curr = 0
        lastSign = '+'
        stack = []

        for i in range(len(s)):
            c = s[i]
            if c.isdigit():
                curr = curr*10 + int(c)

            if not c.isdigit() and c != ' ' or i == len(s)-1:
                if lastSign=='+':
                    stack.append(+curr)
                if lastSign=='-':
                    stack.append(-curr)
                if lastSign=='*':
                    stack.append(stack.pop() * curr)
                if lastSign=='/':
                    top = stack.pop()
                    if top<0:
                        stack.append(int(-(-top / curr)))
                    else:
                        stack.append(int(top / curr))
                
                # update "lastSign" and "curr"
                curr = 0
                lastSign = c

        calc = 0
        while(stack):
            calc = calc + stack.pop()
        
        return calc