# Approach:
# Time - O(1) constant operations at worst case 4 steps to calculate, constant triplets
# Space - O(1) 

class Solution:
    def numberToWords(self, num: int) -> str:

        # edge case, we dont want to proceed if the number is 0
        if num == 0:
            return "Zero"

        # for all these arrays, we will add the empty string as 0th index for easier reference
           
        self.below20 = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten","Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen","Sixteen", "Seventeen", "Eighteen", "Nineteen"]
        
        self.tens = ["", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
        self.thousands = ["", "Thousand", "Million", "Billion"]

        result = ""
        i = 0 # index var to iterate over thousands array

        while num > 0:

            if num % 1000 != 0:

                result = self.helper(num % 1000) + self.thousands[i] + " " + result 


            num = num // 1000
            i += 1

        return result.rstrip() # since we return result with extra spaces, trim while returning



    def helper(self, num):

        if num == 0:
            return ""

        elif num < 20:
            return self.below20[num] + " "

        elif num < 100:

            return self.tens[num // 10] + " " + self.helper(num % 10)

        else:
            return self.below20[num // 100] + " Hundred " + self.helper(num % 100)