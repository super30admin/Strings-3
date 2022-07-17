# Time Complexity : O(n)
# Space Complexity : O(1);
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
from collections import deque


class Solution:
    def helper(self, num):
        if num == 0:
            return ''
        elif num < 20:
            return self.below_20[num]
        elif num < 100:
            return self.Tens[num // 10] + self.below_20[num % 10]
        else:
            return self.below_20[num // 100] + 'Hundred ' + self.helper(num % 100)

    def numberToWords(self, num: int) -> str:
        self.below_20 = ['', 'One ', 'Two ', 'Three ', 'Four ', 'Five ', 'Six ', 'Seven ', 'Eight ', 'Nine ', 'Ten ',
                         'Eleven ', 'Twelve ', 'Thirteen ', 'Fourteen ', 'Fifteen ', 'Sixteen ', 'Seventeen ',
                         'Eighteen ', 'Nineteen ']
        self.Tens = ['', 'Ten ', 'Twenty ', 'Thirty ', 'Forty ', 'Fifty ', 'Sixty ', 'Seventy ', 'Eighty ', 'Ninety ']
        hundreds = ['', 'Thousand ', 'Million ', 'Billion ']
        result = deque()
        ptr = 0
        while num > 0:
            curr = num % 1000
            if curr != 0:
                result.appendleft(self.helper(curr) + hundreds[ptr])
            num = num//1000
            ptr += 1
        print(result)
        result = ''.join(result)
        result = result.strip(result[-1])
        return result


print(Solution().numberToWords(123456))