class Solution:

    def numberToWords(self, num: int) -> str:



        self.thousands = ["", "Thousand", "Million", "Billion"]

        self.below_20 = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",

        "Sixteen", "Seventeen", "Eighteen", "Nineteen"]

        self.tens = ["", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]



        if num == 0:

            return "Zero"

        

        res = ""

        i = 0



        while num > 0:

            if num % 1000 != 0:

                res = self.helper(num%1000) + self.thousands[i] + " " + res

            i += 1

            num = num // 1000



        return res.strip()



    def helper(self, n):

        if n == 0:

            return ""

        elif n < 20:

            return self.below_20[n] + " "

        elif n < 100:

            return self.tens[n//10] + " " + self.helper(n%10)

        else:

            return self.below_20[n//100] + ' Hundred ' + self.helper(n%100)
