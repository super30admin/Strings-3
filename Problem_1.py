class Solution:
    ones = [
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
    tens = [
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
    suffix = ["", " Thousand", " Million", " Billion"]

    def numberToWords(self, num):
        if num == 0:
            return "Zero"
        result = []
        i = 0

        while num != 0:
            triplet = num % 1000
            if triplet > 0:
                temp = self.helper(triplet).strip() + self.suffix[i]
                result.append(temp)
            i += 1
            num = num // 1000

        return " ".join(result[::-1])

    def helper(self, num):
        if num < 20:
            return self.ones[num]
        elif num < 100:
            return self.tens[num // 10] + " " + self.helper(num % 10)
        else:
            return self.ones[num // 100] + " Hundred " + self.helper(num % 100)
