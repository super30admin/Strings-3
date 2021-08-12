class Solution:
    def numberToWords(self, num: int) -> str:
        #We only consider zero in this case, otherwise everywhere else we will ignore 0
        if num==0:
            return "Zero"
        suffix=["","Thousand","Million","Billion"]
        
        onetotwenty={1:"One",2:"Two",3:"Three",4:"Four",5:"Five",6:"Six",7:"Seven",8:"Eight",9:"Nine",10:"Ten",11:"Eleven",12:"Twelve",13:"Thirteen",14:"Fourteen",15:"Fifteen",16:"Sixteen",17:"Seventeen",18:"Eighteen",19:"Nineteen"}
        tens={20:"Twenty",30:"Thirty",40:"Forty",50:"Fifty",60:"Sixty",70:"Seventy",80:"Eighty",90:"Ninety"}
        result=""
        idx=0
        #Helper to calculate num in pairs of 3 and we will then combine the suffix
        def helper(nump):
            if nump==0:
                return ""
            if nump<20:
                return onetotwenty[nump]+" "
            elif nump<100:#less than 100 we get the tens +onetotwenty
                v=(nump//10)*10
                return tens[v]+" "+helper(nump%10)
            else:
                v=(nump//100)
                return onetotwenty[v]+" Hundred "+helper(nump%100)
                
            
        while(num>0):
            #Divide by thousand to get 3 digits
            
            if (num%1000>0):
                #we will combine the result at last as we are processing from right to left
                result=helper(num%1000)+suffix[idx]+" "+result
                #divide the number by 1000 to remove last 3 digits
            num=num//1000
            idx+=1
        return result.strip()
        #Time O(n), n=number of digits in num but it is constant
        #Space O(1)
            
            
