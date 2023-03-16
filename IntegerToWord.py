#All TC passed on leetcode

class Solution:
    def numberToWords(self, num: int) -> str:

        #Here we take triplets of given number. Each triplet has 3 digits and each digit value is computed using the predefined values in tens and below_20 list. 
        #Time complexity - O(n) -> O(1) where n is no. of digits as no. of digits is max 12 for billion hence constant
        #Space complexity - O(1)

        thousands = ["", "Thousand", "Million", "Billion"]
        tens = ["", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
        below_20 = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]

        def helper(n):
            if n==0:
                return ""

            if n<=19:
                return below_20[n] + " "

            elif 20<=n<=99:
                return tens[n//10] + " " + helper(n%10)

            elif 100<=n<=999:
                return below_20[n//100] + " Hundred " + helper(n%100)


        res = ""
        i=0
        if num==0:
            return "Zero"

        while num>0:
            cur = num%1000
            val = helper(cur)
            if val!="":
                res = val + thousands[i] + " " + res
            i+=1
            num = num//1000
        return res.strip()
        