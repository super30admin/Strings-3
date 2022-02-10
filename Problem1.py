# Time Complexity : O(n) where n is the length of the number but number can not be bigger than 2^31. i.e length
# can not be bigger than 10. hence O(1).
# # Space Complexity:o(1)
# #  Did this code successfully run on Leetcode : Yes


class Solution:
    def numberToWords(self, num: int) -> str:
        self.lower = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
                      "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]

        self.upper = ["", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "seventy", "Eighty", "Ninety"]

        thousand = ["", "Thousand", "Million", "Billion"]

        if num == 0:
            return "Zero"

        result = ""
        i = 0
        while num > 0:
            if num % 1000 != 0:
                result = self.helper(num % 1000) + " " + thousand[i] + " " + result
            num = num // 1000
            i += 1

        return result.strip()

    def helper(self, num):

        if num < 20:
            return self.lower[num]

        elif num < 100:
            return self.upper[num // 10] + " " + self.helper(num % 10)

        else:
            return self.lower[num // 100] + " Hundred " + self.helper(num % 100)
