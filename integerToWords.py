'''
Time Complexity: 0(n)
Space Complexity: 0(1)
Run on leetcode: Yes
'''

'''
1. create 3 arrays for below20, 20 to 90 and all thousands
2. Divide the number into sets of three (hundreds tens and ones) i.e. triplets
3. Recurse the triplets to get the resulant string
'''  
class Solution:
    def __init__(self):
        self.below20 = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",                                      "Thirteen","Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]

        self.hundreds = ["","","Twenty","Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]

        self.thousands = ["", "Thousand", "Million", "Billion"]
    
    def recursive(self, num):
        if num == 0:
            return ''
        elif num < 20:
            return self.below20[num] + ' '
        elif num < 100:
            return self.hundreds[num // 10] + ' ' + self.recursive(num % 10)
        elif num >= 100:
            return self.below20[num // 100] + ' Hundred ' + self.recursive(num % 100) 
    
    def numberToWords(self, num: int) -> str:
        #edge case
        if num == 0:
            return "Zero"

        word = ''
        i = 0
        while num > 0:
            if num % 1000 != 0:
                word = self.recursive(num % 1000) + self.thousands[i] + ' ' + word
            num = num // 1000
            i += 1

        return word.strip()