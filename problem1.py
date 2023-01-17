#time complexity: O(n) n=number of digits
#space complexity: O(1)
#ran on leetcode: Yes
#process every three digits and attach a billion, million or thousand at the end.
class Solution:
    def three_digits(self,num):
        ones=["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
        tens=["","","Twenty", "Thirty", "Forty", "Fifty", "Sixty","Seventy","Eighty","Ninety"]
        #st=""
        if(num>=100):
            #st+=ones[num//100]
            return ones[num//100]+ " Hundred "+self.three_digits(num%100)
        if(num>=0 and num<=19):
            return ones[num]
        else:
            return tens[num//10]+" "+ones[num%10]

    def construct(self,num):
        digits=["","Thousand","Million","Billion"]
        i=0
        st=""
        while(num):
            print("HERE")
            res=self.three_digits(num%1000)
            res=res.rstrip()
            if(res!=""):
                res+=" "+digits[i]+" "
            i+=1
            st=res+st
            num=num//1000
        return st

    def numberToWords(self, num: int) -> str:
        if(num==0):
            return "Zero"
        ans= self.construct(num)
        #print(ans)
        return ans.rstrip()
