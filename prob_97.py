# All the possible variatons in numbers are divided into 3 list and with list indexes we get the number
#Time - O(N)
class Solution:
    def __init__(self):  # initialise the letters
        self.below_20 = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
                         "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
        self.tens = ["", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
                     "Ninety"]  # ten is repested twice
        self.thousands = ["", "Thousand", "Million", "Billion"]

    def numberToWords(self, num: int) -> str:
        # edge case
        if num == 0:
            return "Zero"
        # initialise variables
        word = ""  # return variable
        i = 0  # initialise the string
        while num > 0:
            if num % 1000 != 0:  # to check the  ???
                word = self.helper_func(num % 1000) + self.thousands[i] + " " + word
            i += 1
            num = num // 1000
        return word.strip()

    def helper_func(self, num):
        if num == 0:
            return ""
        elif num < 20:
            return self.below_20[num] + " "
        elif num < 100:
            return self.tens[num // 10] + " " + self.helper_func(num % 10)
        else:
            return self.below_20[num // 100] + " Hundred " + self.helper_func(num % 100)






