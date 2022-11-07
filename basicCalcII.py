# TC - O(S) where s is len of string
# SC - O(1)

class Solution:

    def calculate(self, s: str) -> int:
        if len(s) == 0:
            return 0
        s = s.replace(" ", "")
        curr_num = prev_num = rtnData = 0
        operation = "+"

        i = 0
        while i < len(s):
            char = s[i]
            if char.isdigit():
                while i < len(s) and s[i].isdigit():
                    curr_num = curr_num * 10 + int(s[i])
                    i += 1
                i -= 1

                if operation == "+":
                    rtnData += curr_num
                    prev_num = curr_num

                elif operation == "-":
                    rtnData -= curr_num
                    prev_num = -curr_num

                elif operation == "*":
                    rtnData -= prev_num
                    rtnData += prev_num * curr_num
                    prev_num = prev_num * curr_num

                elif operation == "/":
                    rtnData -= prev_num
                    rtnData += int(prev_num / curr_num)
                    prev_num = int(prev_num / curr_num)

                curr_num = 0
            else:
                operation = char

            i += 1
        return rtnData
