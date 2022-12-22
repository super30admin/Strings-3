# Time Complexity : O(n), Where n is number of digits in the num
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing specific

class Solution:
    def helper(self,td_num: int)->str:
        below_20=("","One","Two", "Three", "Four","Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",	"Seventeen", "Eighteen", "Nineteen")
        tens=("","","Twenty", "Thirty","Forty","Fifty", "Sixty", "Seventy", "Eighty", "Ninety")
        if(td_num<20):
            return below_20[td_num]
        if(td_num>=20 and td_num<=99):
            if(td_num%10==0):
                temp=""
            else:
                temp=" "+self.helper(td_num%10)
            return tens[td_num//10]+temp
        if(td_num>=100 and td_num<=999):
            if(td_num%100==0):
                temp=""
            else:
                temp=" "+self.helper(td_num%100)
            return below_20[td_num//100]+" "+"Hundred"+temp
    def numberToWords(self, num: int) -> str:
        #Edge Case
        if(num==0):
            return "Zero"
        #Actual Logic
        Zeros=("","Thousand", "Million", "Billion")
        i=0
        res=""
        while(num > 0):
            if(num%1000 != 0):
                res=self.helper(num%1000)+" "+Zeros[i]+" "+res
            num = num//1000
            i+=1
        return res.strip()        