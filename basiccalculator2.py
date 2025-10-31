# Time Complexity : O(N) where N is length of s
# Space Complexity : O(N) as we are using stack to store numbers
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes

# Your code here along with comments explaining your approach:
# I am using stack to store the numbers and the last operation seen.
# I am iterating through the string and building the current number.
# When I encounter an operator or reach the end of the string, I will perform the last operation
# and push the result onto the stack.
# At the end, I will sum up all the numbers in the stack to get the final result.



class Solution:
    def calculate(self, s: str) -> int:
        currNum = 0
        stack = []
        operations = {"+","-","*","/"}
        lastOp = '+'
        for i in range(len(s)):
            curr = s[i]
            if curr.isdigit():
                currNum = currNum * 10 + int(curr)
            # print(currNum)
            if curr in operations or i == len(s)- 1:
                if lastOp == '*':
                    stack.append(stack.pop()*currNum)
                elif lastOp == '/':
                    print("gweg")
                    stack.append(int(stack.pop()/currNum))
                elif lastOp == '+':
                    stack.append(currNum)
                elif lastOp == '-':
                    stack.append(-currNum)
                lastOp = curr 
                currNum = 0
            
            # print(stack)
        return sum(stack)
     