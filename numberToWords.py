"""
Time complexity O(1)
2^32 number needs 9  step at max

Space complexity O(1)

"""

class Solution:
    def numberToWords(self, num: int) -> str:
        self.res=""
        
        self.less_than_20 = ["", "One", "Two", "Three", "Four", "Five", "Six",
"Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen",
"Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
"Nineteen"]
        self.tens = ["","Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty",
"Seventy", "Eighty", "Ninety"]
        self.thousands = ["", "Thousand", "Million", "Billion"]
        
        i=0
        if num==0:
            return "Zero"
        while(num>0):
            if(num%1000!=0):
                self.res=self.helper(num%1000)+self.thousands[i]+" "+self.res
            num=num//1000
            i+=1
        return self.res.rstrip()
        
    def helper(self,num):
        if(num==0):
            return ""
        elif(num<20):
            return self.less_than_20[num]+" "
        elif(num<100):
            return self.tens[num//10]+" "+self.helper(num%10)
        else:
            return self.less_than_20[num//100]+" "+"Hundred"+" "+self.helper(num%100)
            
                
                
        