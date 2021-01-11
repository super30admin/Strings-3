class Solution(object):
    #O(n)
    #O(1)>all arrays constant size and stack 3 times filled with each call
    #explanation in notes
    def __init__(self):
        #O(n)
        #O(1)
        #keep first index vacant
        #1 present at index 1
        self.lessThan20=           ["","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"]
        self.tens = ["","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"]
        self.thousands = ["","Thousand","Million","Billion"]

    def numberToWords(self, num):
        if num == 0:
            return "Zero"
        res = ""
        i=0
        #O(n/3)
        #work in triplet fashion
        while num >0:
            #
            if num % 1000 != 0:
                #solve last triplet and add this result at the back, move on to triplets at front
                res = self.helper(num%1000) + self.thousands[i] + " " + res
            num /= 1000
            #indexing for triplet groups
            i+=1
        #remove extra spaces
        return res.strip()
    
    #O(3)
    def helper(self, num):
        #do nothing for zero
        if num == 0:
            return ""
        #if num<20 then go to that block
        elif num < 20:
            return self.lessThan20[num] + " "
        #[20-99]
        elif num < 100:
            return self.tens[num/10] + " " + self.helper(num%10)
        #if number>=100 then add hundred term in between
        else:
            return self.lessThan20[num/100] + " Hundred " + self.helper(num%100)