class Solution:
    def numberToWords(self, num: int) -> str:
        below20= {1:' One', 2:' Two', 3:' Three', 4:' Four', 5:' Five', 6:' Six', 7:' Seven', 8:' Eight', 9:' Nine', 
				10:' Ten', 11:' Eleven', 12:' Twelve', 13:' Thirteen', 14:' Fourteen', 15:' Fifteen', 16:' Sixteen', 
				17:' Seventeen', 18:' Eighteen', 19:' Nineteen'}
        tens = {2:' Twenty', 3:' Thirty', 4:' Forty', 5:' Fifty', 6:' Sixty', 7:' Seventy', 8:' Eighty', 9:' Ninety'}
        thousands=["","Thousand","Million","Billion"]
        
        def recursion(num):
            print(num)
            if num==0:
                return ""
            elif num<20:
                return below20[num] + " "
            elif num<100:
                return tens[num//10] + " " + recursion(num%10)
            elif num>=100:
                return below20[num//100]+" Hundred " +recursion(num%100)
            
            return "ggwp"
        
        if num==0:
            return "Zero"
        
        i=0
        word=""
        while(num>0):
            if num%1000!=0:
                word=recursion(num%1000)+ thousands[i] + "" + word
            i+=1
            num=num//1000
        
        return word.strip()