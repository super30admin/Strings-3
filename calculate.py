# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def calculate(self, s: str) -> int:
        nums = deque()
        lastOp = None
        curNum = 0

        for ch in s:
            if ch == ' ':
                continue
            if ch.isdigit():
                curNum = curNum * 10 + int(ch)
                continue
            if not lastOp or lastOp == '+':
                nums.append(curNum)
            elif lastOp == '-':
                nums.append(-curNum)
            elif lastOp == '*':
                nums.append(nums.pop() * curNum)
            elif lastOp == '/':
                nums.append(int(nums.pop() / curNum))

            curNum = 0
            lastOp = ch
            if len(nums) == 3: nums.appendleft(nums.popleft() + nums.popleft())

        if not lastOp or lastOp == '+':
            nums.append(curNum)
        elif lastOp == '-':
            nums.append(-curNum)
        elif lastOp == '*':
            nums.append(nums.pop() * curNum)
        elif lastOp == '/':
            nums.append(int(nums.pop() / curNum))

        return sum(nums)
