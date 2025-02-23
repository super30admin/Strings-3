# Math approach division and reminder
# TC: O(1)
# SC: O(1)


class Solution:
    def numberToWords(self, num: int) -> str:
        if num == 0:
            return "Zero"
        self.thousands = ["", "Thousand", "Million", "Billion"]
        self.below_20 = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
        self.tens = ["", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
        i = 0
        result = ""
        while num > 0:
            if num % 1000 != 0:
                result = self.magic(num % 1000) + self.thousands[i] + " " + result
            i += 1
            num = num // 1000
        return result.strip()

    def magic(self, num: int):
        if num == 0:
            return ""
        elif num < 20:
            return self.below_20[num] + " "
        elif num < 100:
            return self.tens[num // 10] + " " + self.magic(num % 10)
        else:
            return self.below_20[num // 100] + " Hundred " + self.magic(num % 100) 
