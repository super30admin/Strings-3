# Accepted on leetcode(273)
class Solution:
    def __init__(self):
        # Initial 3 lists declaration as base cases.
        self.below_20 = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
                         "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
        self.tens = ["", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
        self.thousands = ["", "Thousand", "Million", "Billion"]

    def numberToWords(self, num):
        # Edge case
        if num == 0: return "Zero"
        # variables declaration
        word = ""
        i = 0
        # loop for thousands array,
        while num > 0:
            if num % 1000 != 0:
                word = self.helper(num % 1000) + self.thousands[i] + " " + word
                print(word)
            i += 1
            num //= 1000
        return word.strip()

    # helper function is a recursive function used for looping for each thousands(3 digits) numbers
    def helper(self, num):
        if num == 0:
            return ""
        elif num < 20:
            return self.below_20[num] + " "
        elif num < 100:
            return self.tens[num // 10] + " " + self.helper(num % 10)
        else:
            return self.below_20[num // 100] + " Hundred " + self.helper(num % 100)