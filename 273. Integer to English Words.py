'''
T = O(1)
S = O(1)

Approach:
Make arrays and iterate for each 1000s
'''


class Solution:
    def numberToWords(self, num: int) -> str:
        if not num:
            return "Zero"
        
        triplets = ["", " Thousand", " Million", " Billion"]
        
        self.underTwenty = ["", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine", " Ten"," Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen"]
        
        self.tens = ["", " Ten", " Twenty", " Thirty", " Forty"," Fifty", " Sixty", " Seventy", " Eighty", " Ninety"]
        
        string = ""
        
        i = 0
        while num:
            r = num % 1000
            num = num // 1000
            if r:
                words = self.convert(r,"")
                string = words + triplets[i] + string
            i += 1
        return string.strip()
        
    def convert(self,number,word):
        hundred = number // 100
        r = number % 100
        
        if hundred:
            word += self.underTwenty[hundred] + " Hundred"
            return self.convert(r,word)
        elif number < 20:
            word += self.underTwenty[number]
        else:
            tens = number // 10
            ones = number % 10
            word += self.tens[tens]+self.underTwenty[ones]
        return word