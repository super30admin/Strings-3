# Time Complexity : O(n), where n is the length of the input string
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach

# This approach uses a stack to keep track of numbers and evaluates on spot if
# it encounters a multiplication or division operator. Positive and negative integers
# are pushed to stack depending on their sign, The sum of stack is returned at the end
class Solution(object):
    def calculate(self, s):
        if not s:
            return 0

        n, store = len(s), []
        lastSign, num = '+', 0

        for i in range(n):
            char = s[i]
            # Forming number
            if char.isdigit():
                num = num * 10 + int(char)
            # Adding to stack if not num/space or is last num
            if not char.isdigit() and char != ' ' or i == n - 1:
                if lastSign == '+':
                    store.append(num)
                elif lastSign == '-':
                    store.append(-num)
                elif lastSign == '*':
                    store.append(store.pop() * num)
                else:
                    store.append(int(store.pop() / float(num)))
                lastSign, num = char, 0

        return sum(store)

