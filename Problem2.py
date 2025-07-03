"""
I first implemented the solution using three lists to handle unique number words: one for numbers below 20, one for tens, and one for place values (thousand, million, billion). I processed the number in chunks of three digits from right to left, using a helper function to convert each chunk into words. The final result is built by combining these word chunks with their respective place value.
Time Complexity: O(1)
Space Complexity: O(1)
"""
class Solution:

    below20 = ["", "One", "Two", "Three", "Four", "Five", "Six",
    "Seven", "Eight", "Nine", "Ten",
    "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
    "Seventeen", "Eighteen", "Nineteen"]

    tens = ["", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty",
    "Seventy", "Eighty", "Ninety"]

    thousands = ["", "Thousand", "Million", "Billion"]

    def numberToWords(self, num: int) -> str:

        if num == 0:
            return "Zero"

        result = ""
        i = 0
        while num > 0:
            if num % 1000 != 0:
                result = self.helper(num % 1000) + self.thousands[i] + " " + result
            num //= 1000
            i += 1
        return result.strip()
    
    def helper(self, num):

        if num == 0:
            return ""
        elif num < 20:
            return self.below20[num] + " "
        elif num < 100:
            return self.tens[num // 10] + " " + self.helper(num % 10)
        else:
            return self.below20[num // 100] + " Hundred " + self.helper(num % 100)