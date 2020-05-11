"""
# Strings-3

## Problem1
 Integer to English Words (https://leetcode.com/problems/integer-to-english-words/)

Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

Example 1:

Input: 123
Output: "One Hundred Twenty Three"
Example 2:

Input: 12345
Output: "Twelve Thousand Three Hundred Forty Five"
Example 3:

Input: 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
Example 4:

Input: 1234567891
Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"

time - O(N)
SPACE - O(N)
"""


class Solution:
    def numberToWords(self, num: int) -> str:
        if num == 0:
            return "Zero"

        self.below_20 = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                         "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
                         "Nineteen"]

        self.hundred = ["", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]

        self.thousands = ["", "Thousand", "Million", "Billion"]

        word = ""
        i = 0
        while num > 0:

            if num % 1000 != 0:
                word = self.helper(num % 1000) + self.thousands[i] + " " + word

            i += 1
            num = num // 1000

        return word.rstrip()

    def helper(self, num):
        if num == 0:
            return ""
        elif num < 20:
            return self.below_20[num % 20] + " "
        elif num < 100:
            return self.hundred[num // 10] + " " + self.helper(num % 10)
        else:
            print(num % 100)
            return self.below_20[num // 100] + " Hundred " + self.helper(num % 100)

