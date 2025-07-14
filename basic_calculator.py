"""
Approach:
- Use a stack to store numbers affected by + and - operations.
- Use a variable `last` to remember the last operator.
- When encountering *, /: pop from the stack, compute, and push result back.
- When encountering +, -: push Num (or -Num) directly.
- At the end, sum the stack for final result.

Time Complexity: O(n), where n is the length of the string
Space Complexity: O(n), in the worst case all numbers are stored in the stack
"""
class Solution:
    def calculate(self, s):
        stack = []
        last = "+"
        Num = 0
        for i in range(len(s)):
            if s[i].isdigit():
                Num = Num * 10 + int(s[i])
            if (not s[i].isdigit()) and s[i] != '' or i == len(s) - 1:
                if last == '+':
                    stack.append(Num)
                if last == '-':
                    stack.append(-Num)
                if last == '*':
                    stack.append(stack.pop() * Num)
                if last == '/':
                    stack.append(int(stack.pop() / Num))
                last = s[i]
                Num = 0
        return sum(stack)

def main():
    sol = Solution()
    test_cases = [
        ("3+2*2", 7),
        (" 3/2 ", 1),
        (" 3+5 / 2 ", 5),
        ("14-3/2", 13),
        ("100+200*3/2-50", 250),
        ("0", 0),
        ("1-1+1", 1),
    ]
    
    for expr, expected in test_cases:
        result = sol.calculate(expr)
        print(f"Input: '{expr}' => Output: {result} | Expected: {expected} | {'PASS' if result == expected else 'FAIL'}")


if __name__ == "__main__":
    main()