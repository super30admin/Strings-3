"""
Leetcode: https://leetcode.com/problems/integer-to-english-words/
Time Complexity: O(n), Intuitively the output is proportional to the number N of digits in the input.
Space Complexity: O(1), since the output is just a string.

Approach:
1. Create 3 arrays for below20, 20 to 90 and all thousands
2. The idea behind this approach is dividing the number into sets of three (hundreds, tens and ones)
3. For every group of 3, keep adding value from thousands based on counter.
    Rest is a repeated problem which can be solved by recursion.

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""


class Solution:
    def __init__(self):
        # first char left blank so that all index numbers would match their equivalent string
        self.below20 = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
                        "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]

        # Zero and ten place left blank
        self.hundreds = ["", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]

        self.thousands = ["", "Thousand", "Million", "Billion"]

    def numberToWords(self, num: int) -> str:
        # base case
        if num == 0:
            return "Zero"

        word = ''
        i = 0
        while num > 0:
            if num % 1000 != 0:
                word = self.recursive(num % 1000) + self.thousands[i] + ' ' + word
            num = num // 1000
            i += 1

        return word.strip()

    def recursive(self, num):
        if num == 0:
            return ''
        elif num < 20:
            return self.below20[num] + ' '
        elif num < 100:
            return self.hundreds[num // 10] + ' ' + self.recursive(num % 10)
        elif num >= 100:
            return self.below20[num // 100] + ' Hundred ' + self.recursive(num % 100)
