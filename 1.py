'''
Strings-3

Problem1

Integer to English Words (https://leetcode.com/problems/integer-to-english-words/)
'''

class Solution:
    def numberToWords(self, num: int) -> str:
        if num == 0:
            return "Zero"
        
        self.below_20 = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
        self.tens = ["", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
        self.suffix = ["", "Thousand", "Million", "Billion"]

        i = 0
        result = ""
        while num > 0:
            if num % 1000 != 0:
                result = self.helper(num%1000) + self.suffix[i] + " " + result
            i = i+1
            num = num // 1000
        return result.strip()

    def helper(self, num):
        if num == 0:
            return ""
        if num < 20:
            return self.below_20[num] + " "
        elif num < 100:
            return self.tens[num // 10] + " " + self.helper(num % 10)
        else:
            return self.below_20[num//100] + " Hundred " + self.helper(num % 100)
