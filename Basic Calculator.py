# Time Complexity : O(n)
# Space Complexity: O(n)


class Solution:
    def calculate(self, s: str) -> int:
        # Basic approach using stack
        stack = []
        lastsign = "+" # Give + as default lastSign
        num = 0
        for i in range(len(s)):

            if s[i].isdigit():
                num = num * 10 + int(s[i]) # While the next element is digit keep accumulating it as it may have more than 1 digits

            if (not s[i].isdigit()) and s[i] != " " or i == len(s) - 1:
                
                if lastsign == "+":
                    stack.append(num) # Add Current num to stack if last sign is +

                if lastsign == "-":
                    stack.append(-num) # Add negative of Current num to stack if last sign is -

                if lastsign == "*":
                    stack.append(stack.pop() * num)
                    # If last sign is * then pop the last element on the stack, multiply it with current element and push the product to the stack

                if lastsign == "/":
                    stack.append(int(stack.pop() / num)) # Same as with * but with /

                lastsign = s[i] # Update last sign

                num = 0

        return sum(stack) #Return the sum of all elements on the stack