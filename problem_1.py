# Time Complexity - O(1)
# Space Complexity - O(1)


class Solution:
    def numberToWords(self, num: int) -> str:
        thousands = ['', 'Thousand', 'Million', 'Billion', 'Trillion']
        self.under_20 = ['','One','Two','Three','Four','Five','Six','Seven','Eight','Nine','Ten','Eleven','Twelve','Thirteen','Fourteen','Fifteen','Sixteen','Seventeen','Eighteen','Nineteen']
        self.tens = ['','Ten','Twenty','Thirty','Forty','Fifty','Sixty','Seventy','Eighty','Ninety']
        
        if num == 0:
           return "Zero"
        res = ""
        for i in range(len(thousands)):
            if num % 1000 != 0:
                res = self.helper(num%1000) + thousands[i] + " " + res
            num //= 1000
        return res.strip()

    def helper(self, num):
        if num == 0:
            return ""
        elif num < 20:
            return self.under_20[num] + " "
        elif num < 100:
            return self.tens[num//10] + " " + self.helper(num%10)
        else:
            return self.under_20[num//100] + " Hundred " + self.helper(num%100)