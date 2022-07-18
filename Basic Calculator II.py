"""
TC/sc: O(n)/O(n)
"""
class Solution:
    def calculate(self, s: str) -> int:
        curr_num = 0
        last_exp = "+"
        stack = []
        for idx, i in enumerate(s):
            if i.isdigit():
                curr_num = curr_num * 10 + ord(i) - ord('0')
            if (not i.isdigit() and i!=" " ) or idx == len(s)-1 :
                if last_exp == "+":
                    stack.append(curr_num)
                elif last_exp == "-":
                    stack.append(-curr_num)
                elif last_exp == "*":
                    nu = stack.pop()
                    stack.append(nu * curr_num)
                elif last_exp == "/":
                    stack.append(int(stack.pop()/curr_num))
                curr_num = 0
                last_exp = i
        return int(sum(stack))
