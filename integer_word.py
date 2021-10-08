# // Time Complexity :O(12), 12 is the max length of string
# // Space Complexity :O(1)? 
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach





class Solution:
    def __init__(self):
        self.below20=[" ",'One','Two','Three','Four','Five','Six','Seven','Eight','Nine','Ten','Eleven','Twelve','Thirteen','Fourteen','Fifteen','Sixteen','Seventeen','Eighteen','Nineteen']
        self.tens=["  ","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"]
        
    def numberToWords(self, num: int) -> str:
        suffix=["","Thousand","Million","Billion"]
        result=""
        i=0
        if num==0:
            return "Zero"
        while num>0:
            
            x=self.helper(num%1000)
            num=num//1000
            print(x)
            if x is not " ":
                result=x +" "+suffix[i]+" "+ result
            i=i+1
        return result.strip()
    def helper(self,num):
        print(num)
        #base
        
        if num <=19:
            return self.below20[num]
        #logic
        elif num<=99 :
            print(self.tens[num//10])
            return (self.tens[num//10]+" "+self.helper(num%10)).strip()
        elif num>=100:
            print(self.below20[num//100])
            return (self.below20[num//100] +" Hundred "+ self.helper(num%100)).strip()
            
            
            
            
            
        
        