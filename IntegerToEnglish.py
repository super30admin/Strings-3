# Time Complexity : O(1)
# Space Complexity : O(1)

class Solution:
    def __init__(self):
        self.below_20 = [" ", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
                         "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]

        self.tens = [" ", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
        self.thousands = [" ", "Thousand", "Million", "Billion"]

    def numberToWords(self, num: int) -> str:
        if num == 0: return "Zero"
        result = " "
        i = 0  # Index on Thousands array for suffix
        while num > 0:
            # divide into triplets
            if num % 1000 != 0:
                #After Each Triplet, Put a Suffix
                result = self.helper(num % 1000) + self.thousands[i] + " " + result
            num = num // 1000
            i += 1
        return result.strip()

    def helper(self, num):
        if num == 0:
            return ""
        elif num < 20:
            return self.below_20[num] + " "
        elif num < 100:
            return self.tens[num // 10] + " " + self.helper(num % 10)
        else:
            return self.below_20[num // 100] + " " + "Hundred" + " " + self.helper(num % 100)
