'''
Time Complexity - O(n).
Space Complexity - O(1).

Works on Leetcode
'''

class Solution:
    def __init__(self):
        self.below_20=["", " One", " Two"," Three"," Four", " Five", " Six", " Seven", " Eight", " Nine", " Ten", " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen"] # 1 to 20
        self.tens = ["", " Ten", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty", " Ninety"] #10-100
        self.thousands = ["", " Thousand", " Million", " Billion"] #Thousands, Millions, Billions
    def numberToWords(self, num: int) -> str:
        if num == 0:
            return "Zero" #return zero if the number is zero
        i = 0
        res = ""
        while num > 0:
            val = num%1000 #get the triplet
            if val !=0:
                res = self.getBelowThousand(val)+self.thousands[i] + res #get the triplet in words is not zero
            num = int(num/1000) #divide the number by 1000 as we are done with the triplet
            i+=1 #maintain a global i and increment as we process a triplet 
        return res.strip()
         


    def getBelowThousand(self, num)->str:
        if num < 20:
            return self.below_20[int(num)] #if number is below 20 get the number in words
        elif num < 100: #if number is less than 100
            return self.tens[int(num/10)]+ self.getBelowThousand(num%10) #get the tens value and then get the number below 20
        else:
            return self.below_20[int(num/100)]+" Hundred"+self.getBelowThousand(num%100) # get the value from one to 20 and then the remaining two digits for the triplet

        