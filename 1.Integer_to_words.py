// Time Complexity : O(n) 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach.
// We create three strings with below 20 numbers, tens and thousands.
// the pattern here is from the end 3 numbers could be 
// transformed one at a time.
// The base function will transfer 3 digits at hundreds level, thousands, millions level  
// In the end the result is trimmed for any extra spaces.


class Solution:
    # <= 999

    def numto_word(self,nums):
        if nums <= 19:
            return self.below_20[nums]

        elif nums <= 99:
            return self.tens[nums//10] +' '+self.below_20[nums%10]

        elif nums<=999:
            return self.below_20[nums//100] +' Hundred ' + self.numto_word(nums%100)
        
        
    def numberToWords(self, num: int) -> str:
        
        self.below_20 = ['', 'One', 'Two', 'Three', 'Four', 'Five', 'Six', 'Seven', 'Eight',                            'Nine', 'Ten','Eleven', 'Twelve', 'Thirteen', 'Fourteen', 'Fifteen',                          'Sixteen', 'Seventeen','Eighteen', 'Nineteen']

        self.tens     = ['', 'Ten','Twenty', 'Thirty', 'Forty', 'Fifty', 
            'Sixty', 'Seventy', 'Eighty','Ninety']

        self.suffix= [None,'Thousand', 'Million', 'Billion']
        
        
        
        res=''
        i=0
        
        if num ==0:
            return 'Zero'

        while num>0:
            
            h=num%1000
            if h>0:
                s=self.numto_word(h)

                if self.suffix[i]==None:
                    res= s + res 
                else:
                    # print(s,self.suffix[i],res)
                    res= s +' '+ self.suffix[i] +' '+res

            i=i+1

            num=num//1000
        return ' '.join(res.split())
        
        
        