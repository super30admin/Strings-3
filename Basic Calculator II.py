# Using Stack + Tail concept
# TC: O(N) --> N is length of string
# SC: O(1) --> Stack of size 1 will be maintained


class Solution:
    
    # Using Stack + Tail(mess we have created) concept
    # TC: O(N) --> N is length of string
    # SC: O(1) --> Stack of size 1 will be maintained
    
    def calculate(self, s: str) -> int:
        
        if (s == None or len(s) == 0):
            return 0
        
        curr = 0
        lastSign = "+"
        stack = [[0, 0]]
        
        s = s
        
        for i in range(len(s)):
            
            char = s[i]
            
            if (char.isdigit()):
                curr = curr*10 + ord(char) - ord("0")
                
            if ((not char.isdigit() or i == len(s) - 1) and char != " "):
                if (lastSign == "+"):
                    temp = stack.pop()
                    stack.append([temp[0]+curr, curr])
                elif (lastSign == "-"):
                    temp = stack.pop()
                    stack.append([temp[0]-curr, (-1)*curr])
                elif (lastSign == "*"):
                    temp = stack.pop()
                    stack.append([(temp[0]-temp[1]) + (temp[1]*curr), temp[1]*curr])
                elif (lastSign == "/"):
                    temp = stack.pop()
                    stack.append([(temp[0]-temp[1]) + (temp[1]//curr), temp[1]//curr])
                    
                lastSign = char
                curr = 0

            
        return stack.pop()[0]