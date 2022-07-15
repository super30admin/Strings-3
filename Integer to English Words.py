""""// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""


class Solution:
    def numberToWords(self, num: int) -> str:
        self.below_20 = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
                         "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
        self.tens = ["", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
        self.thousand = ["", "Thousand", "Million", "Billion"]

        i = 0
        result = ""
        if (num == 0): return "Zero"
        while (num != 0):
            if (num % 1000 != 0):
                result = self.helper(num % 1000) + self.thousand[i] + " " + result
            i += 1
            num = num // 1000
        return result.strip()

    def helper(self, num):

        if (num == 0):
            return ""

        elif (num < 20):
            return self.below_20[num] + " "

        elif (num < 100):
            return self.tens[num // 10] + " " + self.helper(num % 10)

        else:
            return self.below_20[num // 100] + " Hundred " + self.helper(num % 100)

