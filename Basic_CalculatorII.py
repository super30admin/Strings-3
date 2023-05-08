# Time Complexity : O(n), where n is the length of the input string s
# Space Complexity : O(n), where n is the length of the input string s
class Solution:
    def calculate(self, s: str) -> int:
        stack = []
        num = 0
        operator = '+'
        operators = {'+', '-', '*', '/'}
        
        for i in range(len(s)):
            if s[i].isdigit():
                num = num * 10 + int(s[i])
            
            if s[i] in operators or i == len(s) - 1:
                if operator == '+':
                    stack.append(num)
                elif operator == '-':
                    stack.append(-num)
                elif operator == '*':
                    prev_num = stack.pop()
                    stack.append(prev_num * num)
                elif operator == '/':
                    prev_num = stack.pop()
                    stack.append(int(prev_num / num))
                
                operator = s[i]
                num = 0
        
        return sum(stack)