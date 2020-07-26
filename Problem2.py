# Time Complexity : O(n) 
# Space Complexity :O(log n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
class Solution:
    def calculate(self, s: str) -> int:
        if len(s) == 0:
            return 0 
        st = []                                 # Extra Space = O(logn)
        sign = '+'
        num = 0 
        for i in range(len(s)):                 # Time = O(n)
            if s[i].isdigit():
                num = num * 10 + int(s[i])
            
            if((not s[i].isdigit() and s[i] != ' ')) or i ==  len(s)-1:
                if sign == '+': st.append(num) 
                elif sign == '-': st.append(-num) 
                elif sign == '*': st.append(st.pop() * num)
                elif sign == '/': st.append(int(st.pop() / num))
                num = 0 
                sign = s[i]
        
        result = 0
        while len(st) != 0 : 
            result += st.pop()
        
        return result

if __name__ == "__main__":
    s = Solution()
    print(s.calculate("42"))