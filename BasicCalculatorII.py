#227. Basic Calculator II
class Solution:
    def calculate(self, s: str) -> int:
        #Time Complexity : O(n)
        #Space Complexity : O(1) #no stack used
        
        calc = 0
        sign = "+"
        currNum = 0

        for i in range(len(s)):

            if s[i].isdigit():
                currNum = currNum * 10 + int(s[i])

            if (s[i] != ' ' and s[i].isdigit() == False or i == len(s) - 1):
                #print(calc, s[i], tail)
                if sign == "+": 
                    calc = calc + currNum
                    tail = +currNum
                
                elif sign == "-":
                    calc = calc - currNum
                    tail = -currNum
                
                elif sign == "*":
                    calc = calc - tail + int(tail * currNum)
                    tail = tail * currNum
                
                elif sign == "/":
                    calc = calc - tail + int(tail / currNum)
                    tail = int(tail / currNum)
                    
                currNum = 0
                sign = s[i]
                #print(calc, s[i], tail)
        
        return calc 
        
        
        """
        #Time Complexity : O(n)
        #Space Complexity : O(n) #stack size
        if s == "" or len(s) == 0:
            return 0
        
        st = list()
        
        sign = "+"
        currNum = 0

        for i in range(len(s)):
            ch = s[i]

            if ch.isnumeric():
                 currNum = currNum * 10 + int(ch)
        
            if (ch != ' ' and not ch.isnumeric()) or i == len(s) - 1:
                
                if sign == "+": 
                    st.append(+currNum)
                elif sign == "-": 
                    st.append(-currNum)
                
                elif sign == "*":
                    st.append(st.pop() * currNum)
                elif sign == "/":
                    st.append(int(st.pop() / currNum))
                
                currNum = 0
                sign = ch
                
        print(st)
        result = 0
        while st:
            result = result +  st.pop()

        return result
        """
