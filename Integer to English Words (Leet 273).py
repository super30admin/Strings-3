'''
Using Stack Approach
Time: O(n)
Space: O(n), stack st space
'''

class Solution:
    def calculate(self, s: str) -> int:
        
        if s == '' or len(s) == 0:
            return 0
        
        st = list()
        
        curr = 0
        lastsign = '+'
        
        for i in range(len(s)):
            c = s[i]
            
            if c.isdigit():
                curr = curr * 10 + ord(c) - ord('0')
            
            if (not c.isdigit() and c != ' ') or i == len(s) - 1:
                if lastsign == '+':
                    st.append(curr)
                
                elif lastsign == '-':
                    st.append(-curr)
                
                elif lastsign == '*':
                    st.append(st.pop()*curr)
                
                else:
                    st.append(int(st.pop()/curr))
                
                curr = 0
                lastsign = c
        result = 0
        while len(st) != 0:
            result += st.pop()
        return result


'''
Using calc and tail Approach
Time: O(n)
Space: O(1)
'''


class Solution:
    def calculate(self, s: str) -> int:
        
        if s == '' or len(s) == 0:
            return 0
        
        curr = 0
        calc = 0
        tail = 0
        lastsign = '+'
        
        for i in range(len(s)):
            c = s[i]
            
            if c.isdigit():
                curr = curr * 10 + int(c)
                # curr = curr * 10 + ord(c) - ord('0')
            
            if (not c.isdigit() and c != ' ') or i == len(s) - 1:
                
                if lastsign == '+':
                    calc = calc + curr
                    tail = +curr
                    
                elif lastsign == '-':
                    calc = calc - curr
                    tail = -curr
                
                elif lastsign == '*':
                    calc = calc - tail + (tail * curr)
                    tail = tail * curr
                
                else:
                    calc = calc - tail + int(tail / curr)
                    tail = int(tail / curr)
            
                
                curr = 0
                lastsign = c
        return calc
        