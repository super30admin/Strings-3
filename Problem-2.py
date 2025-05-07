'''
    Time Complexity: O(n)
    Space Complexity: O(1)
'''
class Solution:
    def calculate(self, s: str) -> int:
        calc = tail = cur_num = 0
        last_sign = '+'

        for char in s:
            if char.isdigit():
                cur_num = cur_num * 10 + int(char)
            elif char in ('+', '-', '*', '/'):
                if last_sign == '+':
                    calc += cur_num
                    tail = cur_num
                elif last_sign == '-':
                    calc -= cur_num
                    tail = -cur_num
                elif last_sign == '*':
                    calc = (calc - tail) + (tail * cur_num)
                    tail = tail * cur_num
                else:
                    calc = (calc - tail) + int(tail / cur_num)
                    tail = int(tail / cur_num)

                cur_num = 0
                last_sign = char

        if last_sign == '+':
            calc += cur_num
            tail = cur_num
        elif last_sign == '-':
            calc -= cur_num
            tail = -cur_num
        elif last_sign == '*':
            calc = (calc - tail) + (tail * cur_num)
            tail = tail * cur_num
        else:
            calc = (calc - tail) + int(tail / cur_num)
            tail = int(tail / cur_num)

        cur_num = 0
        last_sign = char

        return calc