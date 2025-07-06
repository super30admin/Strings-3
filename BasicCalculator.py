# Time Complexity: O(n) where n is the length of the string
# Space Complexity: O(n) push n element to the stack if there's no * pr / operation
class Solution:
    def calculate(self, s: str) -> int:
        # if s == None or len(s) == 0:
        #     return 0
        # s = s.strip()
        # lastSign = '+'
        # num = 0
        # stack = []
        # for i in range(len(s)):
        #     if s[i].isdigit():
        #         num = num * 10 + int(s[i])
        #     # Checkif it's a non-digit (operator) or end of the string
        #     if (not s[i].isdigit() and s[i] != " ") or i == len(s) - 1:
        #         if lastSign == '+':
        #             stack.append(num)
        #         if lastSign == '-':
        #             stack.append(-num)
        #         if lastSign == '*':
        #             stack.append(stack.pop()*num)
        #         if lastSign == '/':
        #             stack.append(int(stack.pop()/num))
        #         lastSign = s[i]
        #         num = 0
        # return sum(stack)

# Time Complexity: O(n)
# Space Complexity: O(1)
        if s == None or len(s) == 0:
            return 0
        s = s.strip()
        lastSign = '+'
        num = 0
        calc = 0
        tail = 0
        for i in range(len(s)):
            if s[i].isdigit():
                num = num * 10 + int(s[i])
            # Checkif it's a non-digit (operator) or end of the string
            if (not s[i].isdigit() and s[i] != " ") or i == len(s) - 1:
                if lastSign == '+':
                    calc = calc + num
                    tail = num
                if lastSign == '-':
                    calc = calc - num
                    tail = -num
                if lastSign == '*':
                    calc = calc - tail + (tail*num)
                    tail = tail * num
                if lastSign == '/':
                    calc = calc - tail + int(tail/num)
                    tail = int(tail/num)
                lastSign = s[i]
                num = 0
        return calc
