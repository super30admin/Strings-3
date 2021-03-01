# // Time Complexity : O(1)
# // Space Complexity : O(1)
#  // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# Process numbers in hundreds i.e 3 numbers => divide number by 1000 in each iteration
# use three arrays : under_20, tens, thousands: each will have empty string at start for convenience
# create convertor finction: 
# where if number is <20 we give out result from under_20 array
# if <100 we do n/10 and get the corresponding number from under_20 and call convertor on n%10
# for rest we do n/100 and get the corresponding number from under_20 and call convertor on n%100


class Solution:
    def __init__(self):
        self.below_20 = []
        self.tens = []
        self.thousands = []
        
    def numberToWords(self, num: int) -> str:
        if num == 0: return "Zero"
        #used for 1,2,3 digits
        self.below_20 = ["","One","Two",'Three','Four','Five','Six',"Seven","Eight",'Nine',"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"]
        #used for more than 2 digits
        self.tens = ["","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"]
        self.thousands = ["","Thousand","Million","Billion"]
        res = ''
        i = 0
        while num:
            # if num is not 000
            if num % 1000 != 0:
                # call convertor on num%1000
                res = self.converter(num%1000) + self.thousands[i] +" "+ res
            num = num//1000
            i += 1
            
        return res.rstrip()
    
    def converter(self, n):
        r = ''
        if n == 0:
            return ""
        elif n<20:
            return self.below_20[n] +" "
        elif n<100:
            return self.tens[n//10] +" "+ self.converter(n%10)
        else:
            return self.below_20[n//100] + " Hundred "+ self.converter(n%100)
        