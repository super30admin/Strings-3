#Time Complexity : O(n) where n is the length
#Space Complexity : O(1) 
#Did this code successfully run on Leetcode : Yes

class Solution:
    def numberToWords(self, num: int) -> str:
        
        upto20 = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten" , "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty"]
        tens = ["", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
        thousands = ["", "Thousand", "Million", "Billion"]
        result = ""
        if num == 0:
            return "Zero"
        def helper(num):
            if num == 0:
                return ""
            elif num<20:
                return upto20[num] + " "
            elif num<100:
                return tens[num//10] + " " + helper(num%10)
            else:
                return upto20[num//100] + " Hundred " + helper(num%100)
        for i in range(len(thousands)):
            if num%1000!=0:
                result = helper(num%1000) + thousands[i] +" "+ result 
            num = num//1000 
        
        return result.strip()
    
   
