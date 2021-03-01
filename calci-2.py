# // Time Complexity :  
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# Use stack, when we reach at a sign we do previous signs operations
# in stack put all numbers that can be added later

class Solution:
    def calculate(self, s: str) -> int:
        sign = "+"
        stack = deque()
        num = 0
        res = 0
        for char in range(len(s)):
            i = s[char]
            if i.isdigit():
                num = num*10 + int(i)
            if (not i.isdigit() and i!= " ") or char==len(s)-1:
                
                if sign == "+": stack.append(num)
                elif sign == "-": stack.append(-num)
                elif sign == "*": stack.append(stack.pop()*num)
                elif sign == "/": stack.append(int(stack.pop()/num))
                num = 0
                sign = i
        while stack:
            res = res+stack.pop()
        return res
                