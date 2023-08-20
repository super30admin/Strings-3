# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution:
    def calculate(self, s: str) -> int:
        if s is None:
            return 0
        
        #s = s.strip()
        lastsign = '+'
        curr = 0
        result = []
        
        for i in range(len(s)):
            if s[i].isdigit():
                curr = curr * 10 + int(s[i])
            
            if (not s[i].isdigit() and s[i] != ' ') or i == len(s) - 1:
                if lastsign == '+':
                    result.append(curr)
                elif lastsign == '-':
                    result.append(-curr)
                elif lastsign == '*':
                    a = result.pop()
                    result.append(a * curr)
                else:
                    a = result.pop()
                    if curr != 0:
                        result.append(int(a / curr))  
                
                lastsign = s[i]
                curr = 0
        
        
        return sum(result)

