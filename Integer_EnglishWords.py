class Solution:
    def __init__(self):
        self.tmbmap=["","Thousand", "Million","Billion"]
        self.lessthan_twentymap=["","One", "Two","Three","Four","Five","Six","Seven","Eight", "Nine", "Ten",
                           "Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"]
        self.Morethan_twentymap=["","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"]
        
    def numberToWords(self, num: int) -> str:
        """method using hashmap
        Time complexity-O(1)
        Space complexity-O(1)"""
        if num==0:
            return "Zero"
        # thousands, millions, billions map 
        result=""
        i=0
        while num:
            if(num%1000!=0):
                result=(self.helper(num%1000)).strip()+" "+self.tmbmap[i]+" "+result
            num=num//1000
            result=result.strip()
            i+=1
        return result.strip()
    
    def helper(self, num):
        if num<20:
            return self.lessthan_twentymap[num]
        elif num<100:
            return self.Morethan_twentymap[num//10]+" "+self.helper(num%10)
        else:
            return self.lessthan_twentymap[num//100]+" Hundred "+self.helper(num%100)
            
        
            
                
        
        