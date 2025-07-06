#Time Complexity: O(N)
#Space Complexity: O(N)
class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        s = s.replace(" ","")
        stack = []
        sign = "+"
        num = 0

        for i, char in enumerate(s):

            if char.isdigit():
                num = num * 10 + int(char)

            if char in '+-/*' or i == len(s) - 1:

                if sign == '+':
                    stack.append(num)
                elif sign == '-':
                    stack.append(-num)
                elif sign == "*":
                    stack.append(stack.pop() * num)
                elif sign == "/":
                    prev = stack.pop()
                    stack.append(int(prev / float(num)))
                
                sign = char
                num = 0
        
        return sum(stack)