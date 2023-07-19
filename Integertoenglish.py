# Time Complexity : O(N) for each operation.
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to use 3 arrays for 20's, 100's and thousand and find triplets.

class Solution:
    ones = ['', ' One', ' Two', ' Three', ' Four', ' Five', ' Six', ' Seven', ' Eight', ' Nine', ' Ten', ' Eleven', ' Twelve', ' Thirteen', ' Fourteen', ' Fifteen', ' Sixteen', ' Seventeen', ' Eighteen', ' Nineteen']
    tens = ['', ' Ten', ' Twenty', ' Thirty', ' Forty', ' Fifty', ' Sixty', ' Seventy', ' Eighty', ' Ninety']
    thousands = ['', ' Thousand', ' Million', ' Billion']

    def numberToWords(self, num: int) -> str:
        if num == 0:
            return "Zero"
        i=0
        res=''
        while(num>0):
            triplet=num%1000
            if triplet !=0:
                res= self.helper(triplet)+self.thousands[i]+res
            num=int(num/1000)
            i+=1
        return res.lstrip()

    def helper(self, num):
        if (num<20):
            return self.ones[int(num)]
        elif (num<100):
            return self.tens[int(num/10)]+self.helper(num%10)
        else:
            return self.ones[int(num/100)]+' Hundred'+self.helper(num%100)
        return ''