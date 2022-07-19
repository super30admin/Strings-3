#Time complexity: O(n)
#Space complexity: O(1)
class Solution:
    def calculate(self, s: str) -> int:
        
        st = []
        lastSign = '+'
        currNum, res, n = 0, 0, len(s)
        
        
        for i in range(len(s)):
            char = s[i]
            if char.isdigit():
                currNum = currNum * 10 + (ord(char)-ord('0'))
                
            if ((not char.isdigit()) and char != ' ') or i == n-1:
                if lastSign == '+':
                    st.append(currNum)
                elif lastSign == '-':
                    st.append(-currNum)
                elif lastSign == '*':
                    st.append(st.pop() * currNum)
                elif lastSign == '/':
                    st.append(int(st.pop() / currNum))
                    
                lastSign = char
                currNum = 0
        
        while st:
            res += st.pop()
        
        return res
            
                    
        
                
        
        
