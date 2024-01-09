"""
Time Complexity: O(16) = O(1) Billio can have maximum 4 triplets, to convert each tripet to word maximum 4 operations are required
Space Complexity: O(1) 

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""


class Solution:
    def __init__(self):
        self.below_20 = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                         "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
        self.tens = ["", "Ten", "Twenty", "Thirty", "Forty",
                     "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
        self.thousands = ["", "Thousand", "Million", "Billion"]

    def numberToWords(self, num: int) -> str:
        if num == 0:
            return "Zero"
        i = 0
        result = ""
        while num > 0:
            if num % 1000 != 0:
                result = self.helper(num % 1000) + \
                    self.thousands[i] + " " + result

            num = num // 1000
            i += 1

        return result.strip()

    def helper(self, num):
        if num == 0:
            return ""
        if num < 20:
            return self.below_20[num] + " "
        if num < 100:
            return self.tens[int(num/10)] + " " + self.helper(num % 10)
        if num < 1000:
            return self.below_20[int(num/100)] + " Hundred " + self.helper(num % 100)
