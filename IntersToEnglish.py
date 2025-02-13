class Solution:
    def numberToWords(self, num: int) -> str:
        if num == 0:
            return "Zero"
        self.below_20 = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", 
                 "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", 
                 "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
        self.tens = ["", "", "Twenty", "Thirty", "Forty", "Fifty", 
             "Sixty", "Seventy", "Eighty", "Ninety"]
        self.suffix = ["",  "Thousand" , "Million", "Billion"]

        i = 0
        result = ""
        while num > 0:
            if num % 1000 != 0:
                result = self.function(num % 1000) + self.suffix[i] + " " + result
            i = i + 1
            num = num // 1000
        return result.strip()


    def function(self, num):
        if num == 0:
            return ""
        if num < 20:
            return self.below_20[num] + " "
        elif num < 100:
            return self.tens[int(num / 10)] + " " + self.function(num % 10)
        else:
            return self.below_20[int(num/100)] + " Hundred " + self.function(num %100)
