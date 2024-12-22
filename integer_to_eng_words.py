class Solution:
    def __init__(self):
        self.thousands = ["", "Thousand", "Million", "Billion"]
        self.below20 = [
            "",
            "One",
            "Two",
            "Three",
            "Four",
            "Five",
            "Six",
            "Seven",
            "Eight",
            "Nine",
            "Ten",
            "Eleven",
            "Twelve",
            "Thirteen",
            "Fourteen",
            "Fifteen",
            "Sixteen",
            "Seventeen",
            "Eighteen",
            "Nineteen",
        ]
        self.tens = [
            "",
            "",
            "Twenty",
            "Thirty",
            "Forty",
            "Fifty",
            "Sixty",
            "Seventy",
            "Eighty",
            "Ninety",
        ]

    def numberToWords(self, num):
        if num == 0:
            return "Zero"

        i = 0
        words = ""

        while num > 0:
            words = self.helper(num % 1000) + self.thousands[i]

        return words.strip()

    def helper(self, num):
        if num == 0:
            return ""
        elif num < 20:
            return self.below20[num] + " "
        elif num < 100:
            return self.tens[num // 10] + " " + self.helper(num % 10)
        else:
            return self.below20[num // 100] + " Hundred " + self.helper(num % 100)


# time complexity is O(n)
# space complexity is O(n)
