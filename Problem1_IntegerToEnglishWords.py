# Time Complexity: O(1), since there can be maximum of 12 digits
# Space Complexity: O(1)

class Solution:
    def numberToWords(self, num: int) -> str:

        # Store the necessary words in arrays
        self.below_20 = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
                         "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]

        self.tens = ["", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]

        self.thousands = ["", "Thousand", "Million", "Billion"]

        if num == 0:
            return "Zero"

        result = ""

        # Split every 3 digits of the num (thousands) and return their corresponding words
        i = 0
        while num > 0:
            if num % 1000 != 0:
                result = self.helper(num % 1000) + self.thousands[i] + " " + result
            i += 1
            num = num // 1000

        return result.strip()

    # Helper function to return 3 digit word
    def helper(self, num: int) -> str:
        if num == 0:
            return ""

        elif num < 20:
            return self.below_20[num] + " "

        elif num < 100:
            return self.tens[num // 10] + " " + self.helper(num % 10)

        else:
            return self.below_20[num // 100] + " Hundred " + self.helper(num % 100)
