# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on VScode : Yes
# Any problem you faced while coding this : No

from typing import List

class Solution:
    lower = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
             "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]

    tens = ["", "Ten", "Twenty", "Thirty", "Forty",
            "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]

    thousand = ["", "Thousand", "Million", "Billion"]

    def numberToWords(self, num: int) -> str:
        if num == 0:
            return "Zero"

        res = ""
        i = 0

        while num > 0:

            if num % 1000 != 0:
                res = self.helper(num % 1000) + self.thousand[i] + " " + res

            i = i + 1
            num = num // 1000

        return res.strip()

    def helper(self, num):

        if num == 0:
            return ""

        elif num < 20:
            return self.lower[num] + " "

        elif num < 100:
            return self.tens[num // 10] + " " + self.helper(num % 10)

        else:
            return self.lower[num // 100]+" Hundred " + self.helper(num % 100)